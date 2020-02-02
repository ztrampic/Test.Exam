package helper;

import domen.Projekat;
import domen.Zaposleni;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileProject {

    private List<Projekat> projekatList = new ArrayList<>();
    private Helper helper = new Helper();

    public List<Projekat> getProjekatList() {
        return projekatList;
    }

    public void setProjekatList(List<Projekat> projekatList) {
        this.projekatList = projekatList;
    }

    public FileProject() throws IOException {
        File file = new File("fileProject.txt");
        if (file.exists()) {
            readAndCreateList();
        } else {
            try (PrintWriter writer = new PrintWriter(new File("fileProject.txt"))) {
                writer.println("1;WebApplication;20.12.2019;20.10.2020");
                writer.println("2;ECommerc;12.01.2011;20.12.2019");
                writer.println("3;MobilaReactNative;01.04.2015;20.12.2016");
            } catch (Exception e) {
                e.getMessage();
            }
            readAndCreateList();
        }
    }

    private void readAndCreateList() {
        try (BufferedReader reader = new BufferedReader(new FileReader("fileProject.txt"));) {
            List<String> lista = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lista.add(line);
            }
            this.projekatList = lista.stream().map(line1 -> {
                try {
                    return convertToProject(line1);
                } catch (Exception e) {
                    return null;
                }
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Projekat convertToProject(String line) throws ParseException {
        List<String> list = Arrays.asList(line.split(";"));
        int sifra = Integer.valueOf(list.get(0));
        String naziv = list.get(1);
        Date datumOd = helper.convertAndFormatStringToDate(list.get(2));
        Date datumDo = helper.convertAndFormatStringToDate(list.get(3));
        Projekat projekat = new Projekat();
        projekat.setSifra(sifra);
        projekat.setNaziv(naziv);
        projekat.setDatumOd(datumOd);
        projekat.setDatumDo(datumDo);
        return projekat;
    }
}
