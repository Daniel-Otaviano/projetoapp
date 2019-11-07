package com.example.appfaculdade;

import java.lang.System;

@androidx.room.Entity(tableName = "produtos")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/example/appfaculdade/Produto;", "Ljava/io/Serializable;", "cor", "", "id", "", "produto", "tamanho", "foto", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getCor", "()Ljava/lang/String;", "setCor", "(Ljava/lang/String;)V", "getFoto", "setFoto", "getId", "()I", "setId", "(I)V", "getProduto", "setProduto", "getTamanho", "setTamanho", "toJson", "app_debug"})
public final class Produto implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cor;
    @androidx.room.PrimaryKey()
    private int id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String produto;
    private int tamanho;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String foto;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toJson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCor() {
        return null;
    }
    
    public final void setCor(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProduto() {
        return null;
    }
    
    public final void setProduto(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getTamanho() {
        return 0;
    }
    
    public final void setTamanho(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFoto() {
        return null;
    }
    
    public final void setFoto(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public Produto(@org.jetbrains.annotations.NotNull()
    java.lang.String cor, int id, @org.jetbrains.annotations.NotNull()
    java.lang.String produto, int tamanho, @org.jetbrains.annotations.Nullable()
    java.lang.String foto) {
        super();
    }
}