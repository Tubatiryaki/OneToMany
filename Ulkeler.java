package oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
//JPA taraf�ndan tan�mlanmas� zorunlu olan annotation�d�r. Class��n tablo ile e�le�ece�ini g�sterir.
public class Ulkeler {
	
	    @Id//Primary key�i tan�mlar.
	    @GeneratedValue(strategy = GenerationType.AUTO)//@GeneratedValue: Primary key olarak tan�mlad���m�z
	                                                   // Id�yi otomatik atamaya yarar. Farkl� �e�itleri vard�r.
	     private int id;

	    //Length: karakter say�s�
	    //nullable: null olup olmayacag�
	    //unique:unique olmas� istenen alanlar� belirler
	    //Updatable:update olup olmamas� belirlenir
	    //insertable:insert edilip edilememe durumunu belirler
	    @Column(name="ulke_isim",length = 100,nullable = false,unique = true)
	    private String name;

	    @Column(updatable = false)
	    private int ulkeKodu;

	    //orphanRemoval
	    //CascadeType.REMOVE varsa, e�er parent nesne silinirse,
	    // child/dependent nesne de silinir. A��klamas� ��yle.
	    // Ancak bu se�enek child nesneye null de�eri atarsak veya ba�ka
	    // bir child nesne ile de�i�tirirsek devreye girmez
	    //orphanRemoval
	    //Yani bu se�enek ile ba�� bo� kalan dependent nesne de otomatik olarak silinir.

	    // cascade: parent child iliskisinden dolay� silemedigimiz
	    //sorgular� siler
	    @OneToMany(mappedBy="ulke",orphanRemoval = true,cascade = CascadeType.ALL)//Tablolar�n ili�kisini tan�mlamak i�in mappedBy kullan�l�r.
	                                                                                  //mappedBy kullan�lmayan taraf sahip say�l�r.

	    //mappedBy kulland�g�m�z s�n�f icin ili�kiler tablosu olusmaz

	
	    
	    
	    private List<Sehirler> sehirlist=new ArrayList<>();

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

		public int getUlkeKodu() {
			return ulkeKodu;
		}

		public void setUlkeKodu(int ulkeKodu) {
			this.ulkeKodu = ulkeKodu;
		}

		public List<Sehirler> getSehirlist() {
			return sehirlist;
		}

		public void setSehirlist(List<Sehirler> sehirlist) {
			this.sehirlist = sehirlist;
		}

		@Override
		public String toString() {
			return "Ulkeler [id=" + id + ", name=" + name + ", ulkeKodu=" + ulkeKodu + ", sehirlist=" + sehirlist + "]";
		}

	

	   

	   



}
