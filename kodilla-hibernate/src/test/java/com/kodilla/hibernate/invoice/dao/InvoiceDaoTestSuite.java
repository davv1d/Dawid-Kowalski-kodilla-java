package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product apple = new Product("Apple");
        Product orange = new Product("Orange");

        Item item1 = new Item(new BigDecimal(20), 5);
        item1.setProduct(apple);

        Item item2 = new Item(new BigDecimal(10), 10);
        item2.setProduct(orange);

        Invoice invoice = new Invoice("01/2019");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        invoiceDao.deleteById(id);
    }
}
