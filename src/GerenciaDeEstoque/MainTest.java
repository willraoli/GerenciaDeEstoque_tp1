package GerenciaDeEstoque;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testeNF() {
        Produto pQuilo = new ProdQuilo("will", "covid", 30, 10);
        Date dataNow = new Date(); //data atual
        String dataStr = "datadehoje";
        Item p = new Item(pQuilo, 10);
        ArrayList<Item> relacaoItens = new ArrayList<Item>(); //relação de itens
        NotaFiscal nf = new NotaFiscal(dataStr, relacaoItens); //nota fiscal
        ArrayList<NotaFiscal> arrayNotaFiscal = new ArrayList<NotaFiscal>(); //array de notas fiscais
        double quantidadeVendida;
        int codInfo;

        nf.addItem(p);
        assertEquals(nf.getCodigo(),1);
    }

}