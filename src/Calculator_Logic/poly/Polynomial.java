package Calculator_Logic.poly;

import Calculator_Logic.mono.Monomial;
import Calculator_Logic.scalar.*;

import java.util.*;

public class Polynomial {
    private TreeMap<Integer, Monomial> monomials;

    private Polynomial() {
        this.monomials = new TreeMap<>();
    }

    public static Polynomial build(String input) {
        Polynomial p = new Polynomial();
        input = input.trim().replaceAll("\\s+", " ");
        String[] parts = input.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("0")) continue;

            Scalar scalar;
            if (parts[i].contains("/")) {
                String[] frac = parts[i].split("/");
                scalar = new RationalScalar(Integer.parseInt(frac[0]), Integer.parseInt(frac[1]));
            } else {
                scalar = new IntegerScalar(Integer.parseInt(parts[i]));
            }

            Monomial mono = new Monomial(i, scalar);
            p.monomials.put(i, mono);
        }
        return p;
    }
    public Polynomial add(Polynomial p) {
        Polynomial res = new Polynomial();

        for (Monomial m : this.monomials.values())
            res.addMonomial(m);

        for (Monomial m : p.monomials.values())
            res.addMonomial(m);

        return res;
    }

    private void addMonomial(Monomial m) {
        int exp = m.getExponent();
        if (monomials.containsKey(exp)) {
            Monomial sum = monomials.get(exp).add(m);
            if (sum.getCoefficient().sign() != 0) {
                monomials.put(exp, sum);
            } else {
                monomials.remove(exp);
            }
        } else {
            if (m.getCoefficient().sign() != 0) {
                monomials.put(exp, m);
            }
        }
    }

    public Polynomial mul(Polynomial p) {
        Polynomial result = new Polynomial();
        for (Monomial m1 : this.monomials.values()) {
            for (Monomial m2 : p.monomials.values()) {
                result.addMonomial(m1.mul(m2));
            }
        }
        return result;
    }

    public Scalar evaluate(Scalar s) {
        Scalar res = new IntegerScalar(0);
        for (Monomial m : monomials.values()) {
            res = res.add(m.evaluate(s));
        }
        return res;
    }

    public Polynomial derivative() {
        Polynomial result = new Polynomial();
        for (Monomial m : monomials.values()) {
            if (m.getExponent() == 0) continue;
            result.addMonomial(m.derivative());
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Polynomial)) return false;
        Polynomial other = (Polynomial) obj;
        return this.monomials.equals(other.monomials);
    }

    @Override
    public String toString() {
        if (monomials.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        for (Monomial m : monomials.values()) {
            String term = m.toString();
            if (sb.length() > 0 && m.sign() > 0) sb.append("+");
            sb.append(term);
        }
        return sb.toString();
    }
}
