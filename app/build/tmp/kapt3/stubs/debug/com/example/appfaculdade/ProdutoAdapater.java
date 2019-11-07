package com.example.appfaculdade;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/example/appfaculdade/ProdutoAdapater;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/appfaculdade/ProdutoAdapater$ProdutoItemViewHolder;", "context", "Landroid/content/Context;", "listaDeProdutos", "", "Lcom/example/appfaculdade/Produto;", "(Landroid/content/Context;Ljava/util/List;)V", "getListaDeProdutos", "()Ljava/util/List;", "setListaDeProdutos", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "stringParaBitmap", "Landroid/graphics/Bitmap;", "fotoString", "", "ProdutoItemViewHolder", "app_debug"})
public final class ProdutoAdapater extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.appfaculdade.ProdutoAdapater.ProdutoItemViewHolder> {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.appfaculdade.Produto> listaDeProdutos;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.appfaculdade.ProdutoAdapater.ProdutoItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.appfaculdade.ProdutoAdapater.ProdutoItemViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap stringParaBitmap(@org.jetbrains.annotations.NotNull()
    java.lang.String fotoString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.appfaculdade.Produto> getListaDeProdutos() {
        return null;
    }
    
    public final void setListaDeProdutos(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.appfaculdade.Produto> p0) {
    }
    
    public ProdutoAdapater(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.appfaculdade.Produto> listaDeProdutos) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/example/appfaculdade/ProdutoAdapater$ProdutoItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "setView", "app_debug"})
    public static final class ProdutoItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View view;
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        public final void setView(@org.jetbrains.annotations.NotNull()
        android.view.View p0) {
        }
        
        public ProdutoItemViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}