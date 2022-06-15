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
//JPA tarafýndan tanýmlanmasý zorunlu olan annotation’dýr. Class’ýn tablo ile eþleþeceðini gösterir.
public class Ulkeler {
	
	    @Id//Primary key’i tanýmlar.
	    @GeneratedValue(strategy = GenerationType.AUTO)//@GeneratedValue: Primary key olarak tanýmladýðýmýz
	                                                   // Id’yi otomatik atamaya yarar. Farklý çeþitleri vardýr.
	     private int id;

	    //Length: karakter sayýsý
	    //nullable: null olup olmayacagý
	    //unique:unique olmasý istenen alanlarý belirler
	    //Updatable:update olup olmamasý belirlenir
	    //insertable:insert edilip edilememe durumunu belirler
	    @Column(name="ulke_isim",length = 100,nullable = false,unique = true)
	    private String name;

	    @Column(updatable = false)
	    private int ulkeKodu;

	    //orphanRemoval
	    //CascadeType.REMOVE varsa, eðer parent nesne silinirse,
	    // child/dependent nesne de silinir. Açýklamasý þöyle.
	    // Ancak bu seçenek child nesneye null deðeri atarsak veya baþka
	    // bir child nesne ile deðiþtirirsek devreye girmez
	    //orphanRemoval
	    //Yani bu seçenek ile baþý boþ kalan dependent nesne de otomatik olarak silinir.

	    // cascade: parent child iliskisinden dolayý silemedigimiz
	    //sorgularý siler
	    @OneToMany(mappedBy="ulke",orphanRemoval = true,cascade = CascadeType.ALL)//Tablolarýn iliþkisini tanýmlamak için mappedBy kullanýlýr.
	                                                                                  //mappedBy kullanýlmayan taraf sahip sayýlýr.

	    //mappedBy kullandýgýmýz sýnýf icin iliþkiler tablosu olusmaz

	
	    
	    
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
