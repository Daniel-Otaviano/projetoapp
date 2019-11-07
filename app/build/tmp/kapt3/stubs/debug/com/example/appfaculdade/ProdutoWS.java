package com.example.appfaculdade;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0012\u001a\u0002H\u0013\"\u0006\b\u0000\u0010\u0013\u0018\u00012\u0006\u0010\u0014\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lcom/example/appfaculdade/ProdutoWS;", "", "()V", "host", "", "getHost", "()Ljava/lang/String;", "delete", "", "produto", "Lcom/example/appfaculdade/Produto;", "context", "Landroid/content/Context;", "existeProduto", "", "getProdutos", "", "isInternetDisponivel", "parseJson", "T", "json", "(Ljava/lang/String;)Ljava/lang/Object;", "salvarProdutoOffline", "save", "app_debug"})
public final class ProdutoWS {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String host = "http://lucaskurata.pythonanywhere.com/produtos";
    public static final com.example.appfaculdade.ProdutoWS INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHost() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.appfaculdade.Produto> getProdutos(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final boolean isInternetDisponivel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean salvarProdutoOffline(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.appfaculdade.Produto produto) {
        return false;
    }
    
    public final boolean existeProduto(@org.jetbrains.annotations.NotNull()
    com.example.appfaculdade.Produto produto, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String save(@org.jetbrains.annotations.NotNull()
    com.example.appfaculdade.Produto produto, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull()
    com.example.appfaculdade.Produto produto, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private ProdutoWS() {
        super();
    }
}