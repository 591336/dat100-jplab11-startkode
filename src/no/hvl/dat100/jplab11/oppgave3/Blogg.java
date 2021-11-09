package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	Innlegg[] innleggtabell;
	int nesteledig = 0;

	public Blogg() {
		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {

		int j = -1;
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				j = i;
			}
		}
		return j;
	}

	public boolean finnes(Innlegg innlegg) {

		if (finnInnlegg(innlegg) >= 0) {
			return true;
		}
		return false;
	}

	public boolean ledigPlass() {

		if (nesteledig < innleggtabell.length) {
			return true;
		}
		return false;
	}

	public boolean leggTil(Innlegg innlegg) {

		if (finnes(innlegg) == false && nesteledig < innleggtabell.length) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}

	public String toString() {
		String teksten = "" + nesteledig + "\n";
		for (Innlegg i : innleggtabell) {
			teksten += i.toString();
		}
		return teksten;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] utvidettabell = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < innleggtabell.length; i++) {
			utvidettabell[i] = innleggtabell[i];
		}
		innleggtabell = utvidettabell;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				nesteledig -= 1;
				innleggtabell[i] = innleggtabell[nesteledig];
				innleggtabell[nesteledig] = null;
				return true;
			}
		}
		return false;
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}