package com.example.appfaculdade;

import java.lang.System;

@androidx.room.Database(entities = {com.example.appfaculdade.Produto.class, com.example.appfaculdade.Fornecedor.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/appfaculdade/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "fornecedorDAO", "Lcom/example/appfaculdade/FornecedorDAO;", "produtoDAO", "Lcom/example/appfaculdade/ProdutoDAO;", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.appfaculdade.ProdutoDAO produtoDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.appfaculdade.FornecedorDAO fornecedorDAO();
    
    public AppDatabase() {
        super();
    }
}