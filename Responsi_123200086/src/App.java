
public class App {
    public static void main(String[] args) throws Exception {
        MovieModel model = new MovieModel();
        MovieView view = new MovieView();
        MovieController controller = new MovieController(view, model);
    }
}
