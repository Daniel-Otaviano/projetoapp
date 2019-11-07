package com.example.appfaculdade;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ProdutoDAO _produtoDAO;

  private volatile FornecedorDAO _fornecedorDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `produtos` (`cor` TEXT NOT NULL, `id` INTEGER NOT NULL, `produto` TEXT NOT NULL, `tamanho` INTEGER NOT NULL, `foto` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `fornecedores` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `codigo` INTEGER NOT NULL, `cidade` TEXT NOT NULL, `estado` TEXT NOT NULL, `endereco` TEXT NOT NULL, `foto` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fd8fe8532f874b6eb1dbc408a1a295b3')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `produtos`");
        _db.execSQL("DROP TABLE IF EXISTS `fornecedores`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsProdutos = new HashMap<String, TableInfo.Column>(5);
        _columnsProdutos.put("cor", new TableInfo.Column("cor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("produto", new TableInfo.Column("produto", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("tamanho", new TableInfo.Column("tamanho", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProdutos.put("foto", new TableInfo.Column("foto", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProdutos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProdutos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProdutos = new TableInfo("produtos", _columnsProdutos, _foreignKeysProdutos, _indicesProdutos);
        final TableInfo _existingProdutos = TableInfo.read(_db, "produtos");
        if (! _infoProdutos.equals(_existingProdutos)) {
          return new RoomOpenHelper.ValidationResult(false, "produtos(com.example.appfaculdade.Produto).\n"
                  + " Expected:\n" + _infoProdutos + "\n"
                  + " Found:\n" + _existingProdutos);
        }
        final HashMap<String, TableInfo.Column> _columnsFornecedores = new HashMap<String, TableInfo.Column>(7);
        _columnsFornecedores.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFornecedores.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFornecedores.put("codigo", new TableInfo.Column("codigo", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFornecedores.put("cidade", new TableInfo.Column("cidade", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFornecedores.put("estado", new TableInfo.Column("estado", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFornecedores.put("endereco", new TableInfo.Column("endereco", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFornecedores.put("foto", new TableInfo.Column("foto", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFornecedores = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFornecedores = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFornecedores = new TableInfo("fornecedores", _columnsFornecedores, _foreignKeysFornecedores, _indicesFornecedores);
        final TableInfo _existingFornecedores = TableInfo.read(_db, "fornecedores");
        if (! _infoFornecedores.equals(_existingFornecedores)) {
          return new RoomOpenHelper.ValidationResult(false, "fornecedores(com.example.appfaculdade.Fornecedor).\n"
                  + " Expected:\n" + _infoFornecedores + "\n"
                  + " Found:\n" + _existingFornecedores);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fd8fe8532f874b6eb1dbc408a1a295b3", "767a366420fcec55aa5a4e8fb69ed0f8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "produtos","fornecedores");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `produtos`");
      _db.execSQL("DELETE FROM `fornecedores`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ProdutoDAO produtoDAO() {
    if (_produtoDAO != null) {
      return _produtoDAO;
    } else {
      synchronized(this) {
        if(_produtoDAO == null) {
          _produtoDAO = new ProdutoDAO_Impl(this);
        }
        return _produtoDAO;
      }
    }
  }

  @Override
  public FornecedorDAO fornecedorDAO() {
    if (_fornecedorDAO != null) {
      return _fornecedorDAO;
    } else {
      synchronized(this) {
        if(_fornecedorDAO == null) {
          _fornecedorDAO = new FornecedorDAO_Impl(this);
        }
        return _fornecedorDAO;
      }
    }
  }
}
