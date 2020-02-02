package helper;

import domen.Zaposleni;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileZaposleni {

    private List<Zaposleni> list = new ArrayList<>();

    public List<Zaposleni> getList() {
        return list;
    }

    public void setList(List<Zaposleni> list) {
        this.list = list;
    }

    public FileZaposleni() throws IOException {
        File file = new File("fileZaposleni.txt");
        if (file.exists()){
              readAndCreateList();
        }else {
            try (PrintWriter writer = new PrintWriter(new File("fileZaposleni.txt"))){
                writer.println("1;Zarko;Trampic;false");
                writer.println("2;Pera;Peric;false");
                writer.println("3;Mica;Micic;false");
                writer.println("4;Cica;Cicic;false");
            }catch (Exception e){
                e.getMessage();
            }
            readAndCreateList();
        }
    }

    private void readAndCreateList() {
        try(BufferedReader reader = new BufferedReader(new FileReader("fileZaposleni.txt"));){
            List<String> lista = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null){
                lista.add(line);
            }
            this.list = lista.stream().map(line1 ->{
                try {
                    return convertToZaposleni(line1);
                }catch (Exception e){
                    return null;
                }
            }).collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Zaposleni convertToZaposleni(String line) {
        List<String> list = Arrays.asList(line.split(";"));
        int sifra = Integer.valueOf(list.get(0));
        String ime = list.get(1);
        String prezime = list.get(2);
        boolean isDeleted = Boolean.parseBoolean(list.get(3));
        Zaposleni zaposleni = new Zaposleni(sifra,ime,prezime,isDeleted);
        return zaposleni;
    }

}
