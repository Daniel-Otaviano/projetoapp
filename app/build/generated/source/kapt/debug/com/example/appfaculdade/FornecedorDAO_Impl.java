package com.example.appfaculdade;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FornecedorDAO_Impl implements FornecedorDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Fornecedor> __insertionAdapterOfFornecedor;

  private final EntityDeletionOrUpdateAdapter<Fornecedor> __deletionAdapterOfFornecedor;

  public FornecedorDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFornecedor = new EntityInsertionAdapter<Fornecedor>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `fornecedores` (`id`,`nome`,`codigo`,`cidade`,`estado`,`endereco`,`foto`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Fornecedor value) {
        stmt.bindLong(1, value.getId());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        stmt.bindLong(3, value.getCodigo());
        if (value.getCidade() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCidade());
        }
        if (value.getEstado() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEstado());
        }
        if (value.getEndereco() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEndereco());
        }
        if (value.getFoto() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFoto());
        }
      }
    };
    this.__deletionAdapterOfFornecedor = new EntityDeletionOrUpdateAdapter<Fornecedor>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `fornecedores` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Fornecedor value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insert(final Fornecedor fornecedor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFornecedor.insert(fornecedor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Fornecedor fornecedor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFornecedor.handle(fornecedor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Fornecedor> findAll() {
    final String _sql = "SELECT * FROM fornecedores";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
      final int _cursorIndexOfCidade = CursorUtil.getColumnIndexOrThrow(_cursor, "cidade");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "endereco");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final List<Fornecedor> _result = new ArrayList<Fornecedor>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Fornecedor _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        final int _tmpCodigo;
        _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        final String _tmpCidade;
        _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final String _tmpEndereco;
        _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _item = new Fornecedor(_tmpId,_tmpNome,_tmpCodigo,_tmpCidade,_tmpEstado,_tmpEndereco,_tmpFoto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Fornecedor findFornecedorById(final int id) {
    final String _sql = "SELECT * FROM fornecedores WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
      final int _cursorIndexOfCidade = CursorUtil.getColumnIndexOrThrow(_cursor, "cidade");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "endereco");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final Fornecedor _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        final int _tmpCodigo;
        _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        final String _tmpCidade;
        _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final String _tmpEndereco;
        _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _result = new Fornecedor(_tmpId,_tmpNome,_tmpCodigo,_tmpCidade,_tmpEstado,_tmpEndereco,_tmpFoto);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
