package com.example.appfaculdade;

import java.lang.System;

@androidx.room.Entity(tableName = "fornecedores")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u001e\u001a\u00020\u0005R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/example/appfaculdade/Fornecedor;", "Ljava/io/Serializable;", "id", "", "nome", "", "codigo", "cidade", "estado", "endereco", "foto", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCidade", "()Ljava/lang/String;", "setCidade", "(Ljava/lang/String;)V", "getCodigo", "()I", "setCodigo", "(I)V", "getEndereco", "setEndereco", "getEstado", "setEstado", "getFoto", "setFoto", "getId", "setId", "getNome", "setNome", "toJson", "app_debug"})
public final class Fornecedor implements java.io.Serializable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nome;
    private int codigo;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cidade;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String estado;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String endereco;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String foto;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toJson() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNome() {
        return null;
    }
    
    public final void setNome(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getCodigo() {
        return 0;
    }
    
    public final void setCodigo(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCidade() {
        return null;
    }
    
    public final void setCidade(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEstado() {
        return null;
    }
    
    public final void setEstado(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEndereco() {
        return null;
    }
    
    public final void setEndereco(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFoto() {
        return null;
    }
    
    public final void setFoto(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public Fornecedor(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String nome, int codigo, @org.jetbrains.annotations.NotNull()
    java.lang.String cidade, @org.jetbrains.annotations.NotNull()
    java.lang.String estado, @org.jetbrains.annotations.NotNull()
    java.lang.String endereco, @org.jetbrains.annotations.Nullable()
    java.lang.String foto) {
        super();
    }
}