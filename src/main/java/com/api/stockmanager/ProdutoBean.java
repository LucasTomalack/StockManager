package com.api.stockmanager;

import javax.faces.bean.ManagedBean;
import java.util.Objects;

@ManagedBean(name = "pessoaBean")
public class ProdutoBean {
    private String nomeProduto;
    private String fabricanteProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getFabricanteProduto() {
        return fabricanteProduto;
    }

    public void setFabricanteProduto(String fabricanteProduto) {
        this.fabricanteProduto = fabricanteProduto;
    }
}
