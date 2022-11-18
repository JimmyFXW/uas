package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.JDatePicker;

import model.User;



public class templateFrameFromKTP extends JFrame implements ActionListener{
	JTextField NIKinput;
	JTextField inputNama;
	JTextField inputTempatLahir;
	JDatePicker ttl;
	JRadioButton pria;
	JRadioButton wanita;
	JRadioButton a;
	JRadioButton b;
	JRadioButton o;
	JRadioButton ab;
	JTextField inputAlamat;
	JTextField inputRtRw;
	JTextField inputKelDesa;
	JTextField inputKecamatan;
	JComboBox comboBoxAgama;
	JComboBox comboBoxStatusPerkawinan;
	JCheckBox karyawanSwasta;
	JCheckBox pns;
	JCheckBox wiraswasta;
	JCheckBox akademisi;
	JCheckBox pengangguran;
	JRadioButton wni;
	JRadioButton wna;
	JButton addFoto;
	JButton addTTD;
	JDatePicker inputBerlakuHingga;
	JTextField inputKotaPembuatanKTP;
	JButton insertDatabase;
	JLabel wnaIsi;
	JTextField wnaIsiTextField;
	String fotoKtpDir = "";
    String ttdDir = "";
    Date tanggalPembuatanKTP;
    JDatePicker tanggalLahir;
    ButtonGroup kelamin;
    ButtonGroup goldar;
    ButtonGroup warganegara;
    
	public void ktp() {
		JFrame frame = new JFrame();
		JPanel contentPane;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 867, 765);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Republik Harapan Bangsa");
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title.setBounds(245, 25, 365, 55);
		contentPane.add(title);
		
		JLabel NIK = new JLabel("NIK");
		NIK.setBounds(10, 100, 50, 15);
		contentPane.add(NIK);
		
		NIKinput = new JTextField();
		NIKinput.setBounds(150, 100, 100, 20);
		NIKinput.addActionListener(this);
		contentPane.add(NIKinput);
		
		JLabel nama = new JLabel("Nama");
		nama.setBounds(10, 125, 50, 15);
		contentPane.add(nama);
		
		inputNama = new JTextField();
		inputNama.setBounds(150, 125, 100, 20);
		inputNama.addActionListener(this);
		contentPane.add(inputNama);
		
		JLabel tempatLahir = new JLabel("Tempat Lahir");
		tempatLahir.setBounds(10, 150, 100, 15);
		contentPane.add(tempatLahir);
		
		inputTempatLahir = new JTextField();
		inputTempatLahir.setBounds(150, 150, 100, 20);
		inputTempatLahir.addActionListener(this);
		contentPane.add(inputTempatLahir);
		
		JLabel tanggalLahir = new JLabel("Tanggal Lahir");
		tanggalLahir.setBounds(10, 180, 100, 14);
		contentPane.add(tanggalLahir);
		
		ttl = new JDatePicker();
		ttl.setBounds(150, 180, 100, 20);
		ttl.addActionListener(this);
		contentPane.add(ttl);
		
		JLabel jenisKelamin = new JLabel("Jenis Kelamin");
		jenisKelamin.setBounds(10, 210, 100, 14);
		contentPane.add(jenisKelamin);
		
		pria = new JRadioButton("Pria");
		pria.setBounds(120, 210, 50, 25);
		pria.addActionListener(this);
		contentPane.add(pria);
		
		wanita = new JRadioButton("Wanita");
		wanita.setBounds(170, 210, 75, 25);
		wanita.addActionListener(this);
		contentPane.add(wanita);
		
		kelamin = new ButtonGroup();
		kelamin.add(pria);
		kelamin.add(wanita);
		
		JLabel golonganDarah = new JLabel("Golongan Darah");
		golonganDarah.setBounds(10, 234, 100, 15);
		contentPane.add(golonganDarah);
		
		a = new JRadioButton("A");
		a.setBounds(120, 230, 50, 25);
		a.addActionListener(this);
		contentPane.add(a);
		
		b = new JRadioButton("B");
		b.setBounds(170, 230, 50, 25);
		b.addActionListener(this);
		contentPane.add(b);
		
		o = new JRadioButton("O");
		o.setBounds(220, 230, 50, 25);
		o.addActionListener(this);
		contentPane.add(o);
		
		ab = new JRadioButton("AB");
		ab.setBounds(270, 230, 60, 25);
		ab.addActionListener(this);
		contentPane.add(ab);
		
		goldar = new ButtonGroup();
		goldar.add(a);
		goldar.add(b);
		goldar.add(o);
		goldar.add(ab);
		
		JLabel alamat = new JLabel("Alamat");
		alamat.setBounds(10, 270, 100, 15);
		contentPane.add(alamat);
		
		inputAlamat = new JTextField();
		inputAlamat.setBounds(150, 260, 100, 20);
		inputAlamat.addActionListener(this);
		contentPane.add(inputAlamat);
		
		JLabel rtrw = new JLabel("RT/RW");
		rtrw.setBounds(10, 290, 100, 15);
		contentPane.add(rtrw);
		
		inputRtRw = new JTextField();
		inputRtRw.setBounds(150, 285, 100, 20);
		inputRtRw.addActionListener(this);
		contentPane.add(inputRtRw);
		
		JLabel kelDesa = new JLabel("Kel/Desa");
		kelDesa.setBounds(10, 315, 100, 15);
		contentPane.add(kelDesa);
		
		inputKelDesa = new JTextField();
		inputKelDesa.setBounds(150, 310, 100, 20);
		inputKelDesa.addActionListener(this);
		contentPane.add(inputKelDesa);
		
		JLabel kecamatan = new JLabel("Kecamatan");
		kecamatan.setBounds(10, 340, 100, 15);
		contentPane.add(kecamatan);
		
		inputKecamatan = new JTextField();
		inputKecamatan.setBounds(150, 335, 100, 20);
		inputKecamatan.addActionListener(this);
		contentPane.add(inputKecamatan);
		
		JLabel agama = new JLabel("Agama");
		agama.setBounds(10, 365, 100, 15);
		contentPane.add(agama);
		
		String[] agama2 = {"Islam","Kristen Protestan","Kristen Katolik","Hindu","Buddha", "Konghucu"};    
		comboBoxAgama = new JComboBox(agama2);
		comboBoxAgama.setBounds(150, 360, 100, 20);
		comboBoxAgama.addActionListener(this);
		contentPane.add(comboBoxAgama);
		
		JLabel statusPerkawinan = new JLabel("Status Perkawinan");
		statusPerkawinan.setBounds(10, 390, 100, 15);
		contentPane.add(statusPerkawinan);
		
		String[] statusPerkawinan2 = {"Belum Menikah,","Menikah","Janda/Duda"};  
		comboBoxStatusPerkawinan = new JComboBox(statusPerkawinan2);
		comboBoxStatusPerkawinan.setBounds(150, 390, 100, 20);
		comboBoxStatusPerkawinan.addActionListener(this);
		contentPane.add(comboBoxStatusPerkawinan);
		
		JLabel pekerjaan = new JLabel("Pekerjaan");
		pekerjaan.setBounds(10, 420, 100, 15);
		contentPane.add(pekerjaan);
		
		karyawanSwasta = new JCheckBox("Karyawan Swasta");
		karyawanSwasta.setBounds(120, 420, 150, 25);
		karyawanSwasta.addActionListener(this);
		contentPane.add(karyawanSwasta);
		
		pns = new JCheckBox("PNS");
		pns.setBounds(270, 420, 70, 25);
		pns.addActionListener(this);
		contentPane.add(pns);
		
		wiraswasta = new JCheckBox("Wiraswasta");
		wiraswasta.setBounds(340, 420, 100, 25);
		wiraswasta.addActionListener(this);
		contentPane.add(wiraswasta);
		
		akademisi = new JCheckBox("Akademisi");
		akademisi.setBounds(440, 420, 100, 25);
		akademisi.addActionListener(this);
		contentPane.add(akademisi);
		
		pengangguran = new JCheckBox("Pengangguran");
		pengangguran.setBounds(540, 420, 130, 25);
		pengangguran.addActionListener(this);
		contentPane.add(pengangguran);
		
		JLabel kewarganegaraan = new JLabel("Kewarganegaraan");
		kewarganegaraan.setBounds(10, 445, 125, 15);
		contentPane.add(kewarganegaraan);
		
		wni = new JRadioButton("WNI");
		wni.setBounds(125, 440, 55, 25);
		wni.addActionListener(this);
		contentPane.add(wni);
		
		wna = new JRadioButton("WNA");
		wna.setBounds(180, 440, 55, 25);
		wna.addActionListener(this);
		contentPane.add(wna);
		
		ButtonGroup kewarganegaraanGroup = new ButtonGroup();
		kewarganegaraanGroup.add(wna);
		kewarganegaraanGroup.add(wni);
		
		wnaIsi = new JLabel("Warganegara");
		wnaIsi.setBounds(250, 440, 55, 25);
		contentPane.add(wnaIsi);
		
		wnaIsiTextField = new JTextField();
		wnaIsiTextField.setBounds(310, 440, 55, 25);
		wnaIsiTextField.addActionListener(this);
		contentPane.add(inputKecamatan);
		
		warganegara = new ButtonGroup();
		warganegara.add(wna);
		warganegara.add(wni);
		
		JLabel foto = new JLabel("Foto");
		foto.setBounds(10, 475, 100, 15);
		contentPane.add(foto);
		
		addFoto = new JButton("Add File");
		addFoto.setBounds(150, 470, 90, 25);
		addFoto.addActionListener(this);
		contentPane.add(addFoto);
		
		JLabel ttd = new JLabel("Tanda Tangan");
		ttd.setBounds(10, 505, 100, 15);
		contentPane.add(ttd);
		
		addTTD = new JButton("Add File");
		addTTD.setBounds(150, 500, 90, 25);
		addTTD.addActionListener(this);
		contentPane.add(addTTD);
		
		JLabel berlakuHingga = new JLabel("Berlaku hingga");
		berlakuHingga.setBounds(10, 535, 100, 15);
		contentPane.add(berlakuHingga);
		
		inputBerlakuHingga = new JDatePicker();
		inputBerlakuHingga.setBounds(150, 530, 95, 20);
		inputBerlakuHingga.addActionListener(this);
		contentPane.add(inputBerlakuHingga);
		
		JLabel kotaPembuatanKtp = new JLabel("Kota Pembuatan KTP");
		kotaPembuatanKtp.setBounds(10, 560, 140, 15);
		contentPane.add(kotaPembuatanKtp);
		
		inputKotaPembuatanKTP = new JTextField();
		inputKotaPembuatanKTP.setBounds(150, 560, 95, 20);
		inputKotaPembuatanKTP.addActionListener(this);
		contentPane.add(inputKotaPembuatanKTP);
		
		insertDatabase = new JButton("Insert ke Database");
		insertDatabase.addActionListener(this);
		insertDatabase.setBounds(285, 635, 195, 30);
		contentPane.add(insertDatabase);
		
		frame.add(contentPane);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pengangguran) {
			if (pengangguran.isSelected()) {
                karyawanSwasta.setEnabled(false);
                pns.setEnabled(false);
                wiraswasta.setEnabled(false);
                akademisi.setEnabled(false);
            }
            if (!pengangguran.isSelected()) {
                karyawanSwasta.setEnabled(true);
                pns.setEnabled(true);
                wiraswasta.setEnabled(true);
                akademisi.setEnabled(true);
            }
		}
		else if (e.getSource() == wna) {
	        wnaIsi.setVisible(true);
	        wnaIsiTextField.setVisible(true);
	    } 
		else if (e.getSource() == wni) {
			wnaIsi.setVisible(false);
			wnaIsiTextField.setVisible(false);
		}
		else if(e.getSource() != wni && e.getSource() != wna) {
				wnaIsi.setVisible(false);
				wnaIsiTextField.setVisible(false);
		}
		else if (e.getSource() == addFoto) {
            JFileChooser fotoKtp = new JFileChooser();
            fotoKtp.setDialogTitle("Pilih Foto KTP");
            int fotoReturn = fotoKtp.showOpenDialog(null);
            if (fotoReturn == JFileChooser.APPROVE_OPTION) {
                File file = new File(fotoKtp.getSelectedFile().getPath());
                fotoKtpDir = file.toString();
                JOptionPane.showMessageDialog(null, "insert Foto Berhasil!");
            } else {
                JOptionPane.showMessageDialog(null, "Insert Foto Gagal!");
            }
		}
		else if (e.getSource() == addTTD) {
            JFileChooser fotoTTD = new JFileChooser();
            fotoTTD.setDialogTitle("Pilih Foto ttd");
            int fotoReturn = fotoTTD.showOpenDialog(null);
            if (fotoReturn == fotoTTD.APPROVE_OPTION) {
                File file = new File(fotoTTD.getSelectedFile().getPath());
                ttdDir = file.toString();
                JOptionPane.showMessageDialog(null, "insert Foto Berhasil!");
            } else {
                JOptionPane.showMessageDialog(null, "Insert Foto Gagal!");
            }
		}
//		NIKinput; inputNama; inputTempatLahir;
//		ttl;JRadioButton a;JRadioButton b;JRadioButton o;JRadioButton ab;JTextField inputAlamat;JTextField inputRtRw;
//		JTextField inputKelDesa;JTextField inputKecamatan;JComboBox comboBoxAgama;
//		JComboBox comboBoxStatusPerkawinan;JCheckBox karyawanSwasta;JCheckBox pns;
//		JCheckBox wiraswasta;JCheckBox akademisi;JCheckBox pengangguran;JRadioButton wni;
//		JRadioButton wna;JButton addFoto;JButton addTTD;JDatePicker inputBerlakuHingga;
//		JTextField inputKotaPembuatanKTP;JButton insertDatabase;JLabel wnaIsi;
//		JTextField wnaIsiTextField;String fotoKtpDir = "";String ttdDir = "";
//	    Date tanggalPembuatanKTP;JDatePicker tanggalLahir;kelamin;
//	    ButtonGroup goldar;
		else if (e.getSource() == insertDatabase) {
            if (NIKinput.getText().isBlank() || inputNama.getText().isBlank() || inputTempatLahir.getText().isBlank() || !ttl.isValid() || getRadioValue(kelamin).isBlank() || inputAlamat.getText().isBlank() || inputRtRw.getText().isBlank() || inputKelDesa.getText().isBlank() || inputKecamatan.getText().isBlank() || comboBoxAgama.getSelectedItem().toString().isBlank() || comboBoxStatusPerkawinan.getSelectedItem().toString().isBlank() ||  checkCheckBox(e) || getRadioValue(warganegara).isBlank() || (wna.isSelected() && wnaIsiTextField.getText().isBlank()) || fotoKtpDir.isBlank() || ttdDir.isBlank() || !inputBerlakuHingga.isValid() || inputKotaPembuatanKTP.getText().isBlank() || getRadioValue(goldar).isBlank()) {
                JOptionPane.showMessageDialog(null, "Form harus terisi semua!");
            } else {
                String gender = getRadioValue(kelamin);
                String goldarr = getRadioValue(goldar);
                String pekerjaan = "";
                if (pengangguran.isSelected()) {
                    pekerjaan = "Pengangguran";
                } else {
                    if (karyawanSwasta.isSelected()) {
                        pekerjaan += "Karyawan Swasta";
                    }
                    if (pns.isSelected()) {
                        pekerjaan += ", PNS";
                    }
                    if (wiraswasta.isSelected()) {
                        pekerjaan += ", Wiraswasta";
                    }
                    if (akademisi.isSelected()) {
                        pekerjaan += ", Akademisi";
                    }
                }
                String kewarganegaraan = getRadioValue(warganegara);
                if (kewarganegaraan.equals("WNA")) {
                    kewarganegaraan = "WNA("+wnaIsiTextField.getText()+")";
                }
                String pembuatanTanggal = tanggalPembuatan.getDate()+"-"+tanggalPembuatan.getMonth()+"-"+(tanggalPembuatan.getYear()+1900);
                Date ttll = (Date) ttl.getModel().getValue();
                Date tanggalPembuatan = (Date) inputBerlakuHingga.getModel().getValue();
                Date tanggalPembuatan = (Date) inputBerlakuHingga.getModel().getValue();
//                (String nik, String nama, String tempatLahir, Date ttl, String jenisKelamin, String golDar,
//            			String alamat, String rtrw, String kelDesa, String kecamatan, String agama, String statusPerkawinan,
//            			String pekerjaan, String kewarganegaraan, String foto, String ttd, String berlakuHingga,
//            			String kotaPembuatanKTP, Date tanggalPembuatanKTP)
                User user = new User(NIKinput.getText(), inputNama.getText(), inputTempatLahir.getText(), ttl, getRadioValue(kelamin), getRadioValue(goldar), 
                		inputAlamat.getText(), inputRtRw.getText(), inputKelDesa.getText(), inputKecamatan.getText(), comboBoxAgama.getSelectedItem().toString(),
                		comboBoxStatusPerkawinan.getSelectedItem().toString(), pekerjaan, kewarganegaraan, fotoKtpDir, ttdDir, String.valueOf(tanggalPembuatan), inputKotaPembuatanKTP.getText(), 
                		);
            }
        }
	}
	String getRadioValue(ButtonGroup group) {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }
	boolean checkCheckBox(ActionEvent e) {
		if(e.getSource() == karyawanSwasta) {
			if(karyawanSwasta.isSelected()) {
				return true;
			}
		}
		else if(e.getSource() == pengangguran) {
			if(pengangguran.isSelected()) {
				return true;
			}
		}
		else if(e.getSource() == pns) {
			if(pns.isSelected()) {
				return true;
			}
		}
		else if(e.getSource() == wiraswasta) {
			if(wiraswasta.isSelected()) {
				return true;
			}
		}
		else if(e.getSource() == akademisi) {
			if(akademisi.isSelected()) {
				return true;
			}
		}
		return false;
	}
}
