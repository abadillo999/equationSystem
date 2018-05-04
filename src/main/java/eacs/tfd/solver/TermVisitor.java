package eacs.tfd.solver;
public interface TermVisitor {
	public abstract void visit(Variable variable);

	public abstract void visit(Constant constant);


}
