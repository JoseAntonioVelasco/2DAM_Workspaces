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

namespace Tema4_Actividad5
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

        private void calcular(object sender, RoutedEventArgs e)
        {
            Double radio = 0;
            if(!Double.TryParse(t1.Text,out radio))
            {
                superficie.Content = "No has introducido un numero en Radio";
                return;
            }
            Double esf_superficie = 4 * Math.PI * Math.Pow(radio, 2);
            Double esf_volumen = (double)4/(double)3 * Math.PI * Math.Pow(radio, 3);

            superficie.Content = esf_superficie;
            volumen.Content = esf_volumen;

        }
    }
}
