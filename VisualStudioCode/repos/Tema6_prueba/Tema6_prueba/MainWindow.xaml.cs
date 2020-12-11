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

namespace Tema6_prueba
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

            Tema6_prueba.Database1DataSet database1DataSet = ((Tema6_prueba.Database1DataSet)(this.FindResource("database1DataSet")));
            // Cargar datos en la tabla Clientes. Puede modificar este código según sea necesario.
            Tema6_prueba.Database1DataSetTableAdapters.ClientesTableAdapter database1DataSetClientesTableAdapter = new Tema6_prueba.Database1DataSetTableAdapters.ClientesTableAdapter();
            database1DataSetClientesTableAdapter.Fill(database1DataSet.Clientes);
            System.Windows.Data.CollectionViewSource clientesViewSource = ((System.Windows.Data.CollectionViewSource)(this.FindResource("clientesViewSource")));
            clientesViewSource.View.MoveCurrentToFirst();
            // Cargar datos en la tabla Pedidos. Puede modificar este código según sea necesario.
            Tema6_prueba.Database1DataSetTableAdapters.PedidosTableAdapter database1DataSetPedidosTableAdapter = new Tema6_prueba.Database1DataSetTableAdapters.PedidosTableAdapter();
            database1DataSetPedidosTableAdapter.Fill(database1DataSet.Pedidos);
            System.Windows.Data.CollectionViewSource pedidosViewSource = ((System.Windows.Data.CollectionViewSource)(this.FindResource("pedidosViewSource")));
            pedidosViewSource.View.MoveCurrentToFirst();
        }
    }
}
