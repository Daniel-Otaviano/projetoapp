package com.example.appfaculdade;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0010\u001a\u0002H\u0011\"\u0006\b\u0000\u0010\u0011\u0018\u00012\u0006\u0010\u0012\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/example/appfaculdade/LoginWS;", "", "()V", "host", "", "getHost", "()Ljava/lang/String;", "getUsuario", "Lcom/example/appfaculdade/Usuario;", "context", "Landroid/content/Context;", "user", "senha", "isInternetDisponivel", "", "isLogado", "parseJson", "T", "json", "(Ljava/lang/String;)Ljava/lang/Object;", "permanecerLogado", "", "usuario", "logado", "sair", "app_debug"})
public final class LoginWS {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String host = "http://lucaskurata.pythonanywhere.com/login/5";
    public static final com.example.appfaculdade.LoginWS INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHost() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.appfaculdade.Usuario getUsuario(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String user, @org.jetbrains.annotations.NotNull()
    java.lang.String senha) {
        return null;
    }
    
    public final void permanecerLogado(@org.jetbrains.annotations.NotNull()
    com.example.appfaculdade.Usuario usuario, boolean logado, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void sair(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final boolean isLogado(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean isInternetDisponivel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    private LoginWS() {
        super();
    }
}