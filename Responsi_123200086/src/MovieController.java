import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MovieController {
    MovieView movieView;
    MovieModel movieModel;

    public MovieController(MovieView movieView, MovieModel movieModel) {
        this.movieView = movieView;
        this.movieModel = movieModel;

        movieView.tabel.setModel((new JTable(movieModel.readItem(), movieView.namaKolom)).getModel());

        movieView.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = movieView.getJudul();
                String alur = movieView.getAlur();
                String penokohan = movieView.getPenokohan();
                String akting = movieView.getAkting();

                Double al = Double.parseDouble(alur);
                Double pen = Double.parseDouble(penokohan);
                Double ak = Double.parseDouble(akting);
                Double nilai = (al + pen + ak) / 3;
                movieModel.insertData(judul, al, pen, ak, nilai);

                String datamovie[][] = movieModel.readItem();
                movieView.tabel.setModel((new JTable(datamovie, movieView.namaKolom)).getModel());
            }
        });

        movieView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = movieView.getJudul();
                String alur = movieView.getAlur();
                String penokohan = movieView.getPenokohan();
                String akting = movieView.getAkting();

                Double al = Double.parseDouble(alur);
                Double pen = Double.parseDouble(penokohan);
                Double ak = Double.parseDouble(akting);
                Double nilai = (al + pen + ak) / 3;
                movieModel.updateMovie(judul, al, pen, ak, nilai);

                String datamovie[][] = movieModel.readItem();
                movieView.tabel.setModel((new JTable(datamovie, movieView.namaKolom)).getModel());
            }
        });

        movieView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int baris = movieView.tabel.getSelectedRow();

                String dataterpilih = movieView.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Movie " + dataterpilih + "?", "Pilih Opsi...",
                        JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    movieModel.deleteMovie(dataterpilih);
                    String dataKontak[][] = movieModel.readItem();
                    movieView.tabel.setModel(new JTable(dataKontak, movieView.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

        movieView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                movieView.tfJudul.setText("");
                movieView.tfAlur.setText("");
                movieView.tfAkting.setText("");
                movieView.tfPenokohan.setText("");
            }
        });

    }

}
