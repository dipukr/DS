package ds;

public class Pair<F, S> {

	public final F fst;
	public final S snd;

	public Pair(F fst, S snd) {
		this.fst = fst;
		this.snd = snd;
	}

	public boolean equals(Object other) {
		return other instanceof Pair
			&& eq(fst, ((Pair) other).fst)
			&& eq(snd, ((Pair) other).snd);
	}

	public int hashCode() {
		if (fst == null) return (snd == null) ? 0 : snd.hashCode() + 1;
		else if (snd == null) return fst.hashCode() + 2;
		else return fst.hashCode() * 17 + snd.hashCode();
	}

	public String toString() {
		return String.format("(%s,%s)", fst, snd);
	}

	public static <F, S> Pair<F, S> of(F fst, S snd) {
		return new Pair<F, S>(fst, snd);
	}

	private boolean eq(Object a, Object b) {
		return (a == null && b == null) || (a != null && a.equals(b));
	}
}