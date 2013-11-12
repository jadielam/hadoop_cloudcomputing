/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.HashSet;

/**
 *
 * @author Gautham
 */
public class AttackGraph {
    HashSet<DerivationNode> Nr;
    HashSet<PrimitiveNode> Np;
    HashSet<DerivedNode> Nd;
    HashSet<Edge> E;
    HashSet<LFunction> Lf;
    HashSet<Goal> G;

    public AttackGraph(HashSet<DerivationNode> Nr, HashSet<PrimitiveNode> Np, HashSet<DerivedNode> Nd, HashSet<Edge> E, HashSet<LFunction> Lf, HashSet<Goal> G) {
        this.Nr = Nr;
        this.Np = Np;
        this.Nd = Nd;
        this.E = E;
        this.Lf = Lf;
        this.G = G;
    }

    public HashSet<DerivationNode> getNr() {
        return Nr;
    }

    public HashSet<PrimitiveNode> getNp() {
        return Np;
    }

    public HashSet<DerivedNode> getNd() {
        return Nd;
    }

    public HashSet<Edge> getE() {
        return E;
    }

    public HashSet<LFunction> getLf() {
        return Lf;
    }

    public HashSet<Goal> getG() {
        return G;
    }
    
    
    
}
