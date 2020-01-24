package it.nextre.academy.pr130120.pattern.visitor;

public interface ProdottoVisitor {
    void visit(Gadget prodotto);
    void visit(Libro prodotto);
}
