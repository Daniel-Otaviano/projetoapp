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
public final class ProdutoDAO_Impl implements ProdutoDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Produto> __insertionAdapterOfProduto;

  private final EntityDeletionOrUpdateAdapter<Produto> __deletionAdapterOfProduto;

  public ProdutoDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduto = new EntityInsertionAdapter<Produto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `produtos` (`cor`,`id`,`produto`,`tamanho`,`foto`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Produto value) {
        if (value.getCor() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCor());
        }
        stmt.bindLong(2, value.getId());
        if (value.getProduto() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProduto());
        }
        stmt.bindLong(4, value.getTamanho());
        if (value.getFoto() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFoto());
        }
      }
    };
    this.__deletionAdapterOfProduto = new EntityDeletionOrUpdateAdapter<Produto>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `produtos` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Produto value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insert(final Produto produto) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProduto.insert(produto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Produto produto) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProduto.handle(produto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Produto> findAll() {
    final String _sql = "SELECT * FROM produtos";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCor = CursorUtil.getColumnIndexOrThrow(_cursor, "cor");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfProduto = CursorUtil.getColumnIndexOrThrow(_cursor, "produto");
      final int _cursorIndexOfTamanho = CursorUtil.getColumnIndexOrThrow(_cursor, "tamanho");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final List<Produto> _result = new ArrayList<Produto>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Produto _item;
        final String _tmpCor;
        _tmpCor = _cursor.getString(_cursorIndexOfCor);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpProduto;
        _tmpProduto = _cursor.getString(_cursorIndexOfProduto);
        final int _tmpTamanho;
        _tmpTamanho = _cursor.getInt(_cursorIndexOfTamanho);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _item = new Produto(_tmpCor,_tmpId,_tmpProduto,_tmpTamanho,_tmpFoto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Produto findProdutoById(final int id) {
    final String _sql = "SELECT * FROM produtos WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCor = CursorUtil.getColumnIndexOrThrow(_cursor, "cor");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfProduto = CursorUtil.getColumnIndexOrThrow(_cursor, "produto");
      final int _cursorIndexOfTamanho = CursorUtil.getColumnIndexOrThrow(_cursor, "tamanho");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final Produto _result;
      if(_cursor.moveToFirst()) {
        final String _tmpCor;
        _tmpCor = _cursor.getString(_cursorIndexOfCor);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpProduto;
        _tmpProduto = _cursor.getString(_cursorIndexOfProduto);
        final int _tmpTamanho;
        _tmpTamanho = _cursor.getInt(_cursorIndexOfTamanho);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _result = new Produto(_tmpCor,_tmpId,_tmpProduto,_tmpTamanho,_tmpFoto);
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
