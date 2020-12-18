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

namespace WpfApp12
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

            WpfApp12.baloncestoDataSet baloncestoDataSet = ((WpfApp12.baloncestoDataSet)(this.FindResource("baloncestoDataSet")));
            // Cargar datos en la tabla equipos. Puede modificar este código según sea necesario.
            WpfApp12.baloncestoDataSetTableAdapters.equiposTableAdapter baloncestoDataSetequiposTableAdapter = new WpfApp12.baloncestoDataSetTableAdapters.equiposTableAdapter();
            baloncestoDataSetequiposTableAdapter.Fill(baloncestoDataSet.equipos);
            System.Windows.Data.CollectionViewSource equiposViewSource = ((System.Windows.Data.CollectionViewSource)(this.FindResource("equiposViewSource")));
            equiposViewSource.View.MoveCurrentToFirst();
            WpfApp12.empresaDataSet empresaDataSet = ((WpfApp12.empresaDataSet)(this.FindResource("empresaDataSet")));
            // Cargar datos en la tabla sede. Puede modificar este código según sea necesario.
            WpfApp12.empresaDataSetTableAdapters.sedeTableAdapter empresaDataSetsedeTableAdapter = new WpfApp12.empresaDataSetTableAdapters.sedeTableAdapter();
            empresaDataSetsedeTableAdapter.Fill(empresaDataSet.sede);
            System.Windows.Data.CollectionViewSource sedeViewSource = ((System.Windows.Data.CollectionViewSource)(this.FindResource("sedeViewSource")));
            sedeViewSource.View.MoveCurrentToFirst();
        }
    }
}
