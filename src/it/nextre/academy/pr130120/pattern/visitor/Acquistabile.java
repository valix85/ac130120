package it.nextre.academy.pr130120.pattern.visitor;

public interface Acquistabile {
    double getPrezzo();
    void accept(ProdottoVisitor prod);
}
