using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Tema6_actividad3
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {

            Tema6_actividad3.BibliotecaDataSet bibliotecaDataSet = ((Tema6_actividad3.BibliotecaDataSet)(this.FindResource("bibliotecaDataSet")));
            // Cargar datos en la tabla Libros. Puede modificar este código según sea necesario.
            Tema6_actividad3.BibliotecaDataSetTableAdapters.LibrosTableAdapter bibliotecaDataSetLibrosTableAdapter = new Tema6_actividad3.BibliotecaDataSetTableAdapters.LibrosTableAdapter();
            bibliotecaDataSetLibrosTableAdapter.Fill(bibliotecaDataSet.Libros);
            System.Windows.Data.CollectionViewSource librosViewSource = ((System.Windows.Data.CollectionViewSource)(this.FindResource("librosViewSource")));
            librosViewSource.View.MoveCurrentToFirst();
            // Cargar datos en la tabla Prestamos. Puede modificar este código según sea necesario.
            Tema6_actividad3.BibliotecaDataSetTableAdapters.PrestamosTableAdapter bibliotecaDataSetPrestamosTableAdapter = new Tema6_actividad3.BibliotecaDataSetTableAdapters.PrestamosTableAdapter();
            bibliotecaDataSetPrestamosTableAdapter.Fill(bibliotecaDataSet.Prestamos);
            System.Windows.Data.CollectionViewSource librosPrestamosViewSource = ((System.Windows.Data.CollectionViewSource)(this.FindResource("librosPrestamosViewSource")));
            librosPrestamosViewSource.View.MoveCurrentToFirst();
            // Cargar datos en la tabla Usuarios. Puede modificar este código según sea necesario.
            Tema6_actividad3.BibliotecaDataSetTableAdapters.UsuariosTableAdapter bibliotecaDataSetUsuariosTableAdapter = new Tema6_actividad3.BibliotecaDataSetTableAdapters.UsuariosTableAdapter();
            bibliotecaDataSetUsuariosTableAdapter.Fill(bibliotecaDataSet.Usuarios);
            System.Windows.Data.CollectionViewSource usuariosViewSource = ((System.Windows.Data.CollectionViewSource)(this.FindResource("usuariosViewSource")));
            usuariosViewSource.View.MoveCurrentToFirst();
        }
    }
}
