package oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Sehirler {
	
	   @Id
	    private int id;

	    private String name;

	    private String plaka;

	   

	    @ManyToOne
	    @JoinColumn(name="ulke_sehir")
	    private Ulkeler ulke;

	    
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}

        public String getPlaka() {
			return plaka;
		}


		public void setPlaka(String plaka) {
			this.plaka = plaka;
		}


		public Ulkeler getUlke() {
			return ulke;
		}



		public void setUlke(Ulkeler ulke) {
			this.ulke = ulke;
		}



	    @Override
		public String toString() {
			return "Sehirler [id=" + id + ", name=" + name + ", plaka=" + plaka + ", ulke=" + ulke + "]";
		}


		
		
	    
	    

	    
}
