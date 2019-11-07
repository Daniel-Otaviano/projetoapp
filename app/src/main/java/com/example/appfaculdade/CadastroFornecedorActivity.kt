package com.example.appfaculdade

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_cadastro_fornecedor.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.ByteArrayOutputStream

class CadastroFornecedorActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE = 19
    private var fotoString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_fornecedor)

        //adicionar o actionbar /Toolbar.
        setSupportActionBar(app_toolbar)
        // exibe a setinha de voltar na action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bt_salvar_fornecedor.setOnClickListener {
            val nome = et_fornecedor_nome.text.toString()
            val codigo = et_fornecedor_codigo.text.toString()
            val cidade = et_fornecedor_cidade.text.toString()
            val estado = et_fornecedor_uf.text.toString()
            val endereco = et_fornecedor_endereco.text.toString()
            // criar um metodo post no service

            Thread({
                //verificar ws
                salvarFornecedorBancoDeDados(Fornecedor(0, nome, codigo.toInt(), cidade, estado, endereco, fotoString))
                runOnUiThread {
                    Toast.makeText(this, "Fornecedor Salvo com sucesso", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@CadastroFornecedorActivity, ListarFornecedores::class.java))
                }
            }).start()

        }

        // tirar foto
        bt_tirarfoto_fornecedor.setOnClickListener {
            // verificar permissao no android
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                // pede permissao ao android
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    REQUEST_IMAGE_CAPTURE
                )
            } else {
                // ja tenho permissão
                tirarFotoFornecedor()
            }
        }

    }

    // verificar o resultado do pedido de permissão
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                //permissão ok
                tirarFotoFornecedor()
            } else {
                // sem permissão
            }
        }
    }

    fun salvarFornecedorBancoDeDados(fornecedor: Fornecedor) {
        val dao = DatabaseManger.getDatabase(this)?.fornecedorDAO()
        if (!verificarSeFornecedorExiste(fornecedor))
            dao?.let {
                it.insert(fornecedor)
            }
    }

    fun verificarSeFornecedorExiste(fornecedor: Fornecedor): Boolean {
        val dao = DatabaseManger.getDatabase(this)?.fornecedorDAO()
        return dao?.findFornecedorById(fornecedor.id) != null
    }

    fun tirarFotoFornecedor() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            fotoString = bitmapParaString(imageBitmap) // converte a imagem para string
            iv_fornecedor.setImageBitmap(imageBitmap)
        }
    }

    fun bitmapParaString(foto: Bitmap): String {
        val byteArray = ByteArrayOutputStream()
        foto.compress(Bitmap.CompressFormat.JPEG, 100, byteArray)
        return Base64.encodeToString(byteArray.toByteArray(), Base64.DEFAULT)
    }

}

//@ColumnInfo(name = "your columnname",typeAffinity = ColumnInfo.BLOB)
//private byte[] yourfield;

/*
 private void takePictureOrRecordVideo(int requestCode, String saveFolder, String prefix, String fileType) {
        Intent cameraIntent = null;
        if (requestCode == ChatHelper.CHAT_CAMERA_IMG_REQ) {
            cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        } else if (requestCode == ChatHelper.CHAT_CAMERA_VID_REQ) {
            cameraIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            cameraIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            cameraIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 30);
            //cameraIntent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, 5491520L); // 5 megas
        }
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            // startActivityForResult(cameraIntent, ChatHelper.CHAT_CAMERA_IMG_REQ);
            File currentPhoto = null;
            try {
                currentPhoto = ChatFileUpload.createTempFile(this, null, saveFolder, prefix, fileType, null);
            } catch (IOException ex) {
                Toast.makeText(this, "Não conseguimos tirar a foto", Toast.LENGTH_LONG).show();
            }
            if (currentPhoto == null) {
                Toast.makeText(this, "Não conseguimos tirar a foto", Toast.LENGTH_LONG).show();
            } else {
                try {
                    Uri fileUri = FileProvider.getUriForFile(this, "com.gentebonita.store.gentebonita.fileprovider", currentPhoto);
                    mCurrentPhotoPath = currentPhoto.getAbsolutePath();
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                    startActivityForResult(cameraIntent, requestCode);
                } catch (ClassCastException ex) {
                    ChatFileUpload.deleteAFile(currentPhoto);
                    Toast.makeText(this, "Não conseguimos tirar a foto", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


     // processa principalmente as mensagens do tipo arquivo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ChatHelper.CHAT_UPLOAD_IMG_REQ: {
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        Intent newData = new Intent().setData(Matisse.obtainResult(data).get(0));
                        String mime = ChatHelper.getFileMimeType(this, newData.getData()).toLowerCase();
                        ChatHelper.LogW("MIME : " + mime);
                        if (mime.contains("png") || mime.contains("jpg") || mime.contains("jpeg") || mime.contains("gif") || mime.contains("bmp") || mime.contains("webp")) {
                            processFileMessage(newData, ChatFileUpload.IMG_SENT_FOLDER, ChatHelper.CHAT_UPLOAD_TYPE_IMG, ChatHelper.FILE_IMG_PREFIX);
                        } else {
                            processFileMessage(newData, ChatFileUpload.VID_SENT_FOLDER, ChatHelper.CHAT_UPLOAD_TYPE_VID, ChatHelper.FILE_VID_PREFIX);
                        }
                    }
                }
            }
            break;
            case ChatHelper.CHAT_UPLOAD_AUD_REQ: {
                if (resultCode == RESULT_OK)
                    processFileMessage(data, ChatFileUpload.AUD_SENT_FOLDER, ChatHelper.CHAT_UPLOAD_TYPE_AUD, ChatHelper.FILE_AUD_PREFIX);
            }
            break;
            case ChatHelper.CHAT_UPLOAD_VID_REQ: {
                if (resultCode == RESULT_OK)
                    processFileMessage(data, ChatFileUpload.VID_SENT_FOLDER, ChatHelper.CHAT_UPLOAD_TYPE_VID, ChatHelper.FILE_VID_PREFIX);
            }
            break;
            case ChatHelper.CHAT_UPLOAD_DOC_REQ: {
                if (resultCode == RESULT_OK)
                    processFileMessage(data, ChatFileUpload.DOC_SENT_FOLDER, ChatHelper.CHAT_UPLOAD_TYPE_DOC, ChatHelper.FILE_DOC_PREFIX);
            }
            break;
        }
        if (requestCode == ChatHelper.CHAT_CAMERA_VID_REQ || requestCode == ChatHelper.CHAT_CAMERA_IMG_REQ) {
            if (resultCode == RESULT_OK) {

                String prefix = requestCode == ChatHelper.CHAT_CAMERA_VID_REQ ? ChatHelper.FILE_VID_PREFIX : ChatHelper.FILE_IMG_PREFIX;

                // Cria uma mensagem do tipo file e salva no banco. Automaticament o LiveData atualiza o RecyclverView
                File camFile = new File(mCurrentPhotoPath);

                if (!camFile.exists() || camFile.isDirectory() || !camFile.isFile()) {
                    ChatHelper.toast(this, "Arquivo inválido!");
                    // mudar isso para um crop video
                    ChatFileUpload.deleteAFile(camFile);
                    return;
                }

                if (requestCode == ChatHelper.CHAT_CAMERA_IMG_REQ && camFile.exists()) {
                    File downloadedFile = ChatFileUpload.createLocalImageFileFromCamera(ChatActivity.this, ChatFileUpload.IMG_SENT_FOLDER, ChatHelper.FILE_IMG_PREFIX, camFile);
                    if (downloadedFile != null) {
                        //final Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        //mediaScanIntent.setData(Uri.fromFile(downloadedFile));
                        //this.sendBroadcast(mediaScanIntent);
                        ChatHelper.LogE("IMAGEM SUBISTITUIDA : " + downloadedFile.getPath() + " NAME :");
                    }
                }


                ChatHelper.LogI("Criando Arquivo da camera em:" + mCurrentPhotoPath);

                chatViewModel.insertMessage(ChatMessage.newFileMessage(prefix, myUserId, myChatId, otherUserId, camFile)); // async
                // scrol para a ultima mensagem adcionada
                if (chatAdapter.getItemCount() > 0) {
                    // rvMessages.scrollToPosition(chatAdapter.getItemCount() - 1);
                }
                mCurrentPhotoPath = "";
            }
        }
    }


 */