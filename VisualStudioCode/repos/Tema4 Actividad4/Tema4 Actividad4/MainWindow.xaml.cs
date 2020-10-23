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

namespace Tema4_Actividad4
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

        private void Calcular(object sender, RoutedEventArgs e)
        {
            //(necesidad de combustible = número de turismos *capacidad depósito turismos +número de todoterrenos *capacidad depósito todoterrenos).
            int num_turismos = 0; int num_todoterreno = 0;
            int cap_depo_turi = 0; int cap_dep_tod = 0;

            if(!int.TryParse(t1.Text,out num_turismos))
            {
                resultado.Content = "No has introducido un numero\n en \"numero de turismos\"";
                return;
            }
            if(!int.TryParse(t2.Text, out cap_depo_turi))
            {
                resultado.Content = "No has introducido un numero\n en \"deposito de turismo\"";
                return;
            }
            if(!int.TryParse(t3.Text, out num_todoterreno))
            {
                resultado.Content = "No has introducido un numero\n en \"numero de todoterrenos\"";
                return;
            }
            if(!int.TryParse(t4.Text, out cap_dep_tod))
            {
                resultado.Content = "No has introducido un numero\n en \"deposito de todoterrenos\"";
                return;
            }

            int combustible_necesario = num_turismos * cap_depo_turi + num_todoterreno * cap_dep_tod;
            resultado.Content = "Las necesidades totales de\n combustible son de "+combustible_necesario+" litros";
        }
    }
}
