package GerenciaDeEstoque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final ProdQuilo prodQuiloA = new ProdQuilo("Carne", "Bovina", 25, 50);
    private final ProdQuilo prodQuiloB = new ProdQuilo("Arroz", "Integral", 10, 5);
    private final ProdUnidade prodUnidadeA = new ProdUnidade("Smart TV", "50 polegadas", 1500, 10);
    private final ProdUnidade prodUnidadeB = new ProdUnidade("Ventilador", "Gira muito", 100, 1);
    private final ManipulaProduto produtos = new ManipulaProduto();
    private final ManipulaNotaFiscal notasFiscais = new ManipulaNotaFiscal();
    private final NotaFiscal notaFiscal1 = new NotaFiscal("08/03/2021");
    private final NotaFiscal notaFiscal2 = new NotaFiscal("05/05/2025");
    private final Item item1 = new Item(prodUnidadeA, 1);
    private final Item item2 = new Item(prodUnidadeB, 1);
    private final Item item3 = new Item(prodQuiloA, 1);
    private final Item item4 = new Item(prodQuiloB, 1);

    @BeforeEach
    void setUp() {
        produtos.addProduto(prodUnidadeA);
        produtos.addProduto(prodUnidadeB);
        produtos.addProduto(prodQuiloA);
        produtos.addProduto(prodQuiloB);
        notaFiscal1.addItem(item1);
        notaFiscal1.addItem(item2);
        notaFiscal2.addItem(item3);
        notaFiscal2.addItem(item4);
        notasFiscais.addNotaFiscal(notaFiscal1);
        notasFiscais.addNotaFiscal(notaFiscal2);
    }

    @Test
    void alterarNotaFiscal() {
        assertEquals(notaFiscal1, notaFiscal2);
    }
}