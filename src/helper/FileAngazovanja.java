package helper;

import domen.AngazovanjeNaProjektu;
import domen.Zaposleni;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileAngazovanja {
    private List<AngazovanjeNaProjektu> list = new ArrayList<>();
    private Helper helper = new Helper();

    public List<AngazovanjeNaProjektu> getList() {
        return list;
    }

    public void setList(List<AngazovanjeNaProjektu> list) {
        this.list = list;
    }
    public FileAngazovanja() throws IOException {
        File file = new File("fileAngazovanja.txt");
        if (file.exists()){
            readAndCreateList();
        }else {
            file.createNewFile();
        }
    }
    private void readAndCreateList() {
        try(BufferedReader reader = new BufferedReader(new FileReader("fileAngazovanja.txt"));){
            List<String> lista = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null){
                lista.add(line);
            }
            this.list = lista.stream().map(line1 ->{
                try {
                    return convertToAngazovanja(line1);
                }catch (Exception e){
                    return null;
                }
            }).collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private AngazovanjeNaProjektu convertToAngazovanja(String line) throws ParseException {
        List<String> list = Arrays.asList(line.split(";"));
        AngazovanjeNaProjektu angaz = new AngazovanjeNaProjektu();
        angaz.setBrojRadnihSati(Double.parseDouble(list.get(0)));
        angaz.setDatumDo(helper.convertAndFormatStringToDate(list.get(1)));
        angaz.setDatumOd(helper.convertAndFormatStringToDate(list.get(2)));
        angaz.setSifraProjekat(Integer.parseInt(list.get(3)));
        angaz.setSifraZaposlenog(Integer.parseInt(list.get(4)));
        angaz.setUloga(helper.checkUloga(Integer.valueOf(list.get(5))));
        return angaz;
    }
}
