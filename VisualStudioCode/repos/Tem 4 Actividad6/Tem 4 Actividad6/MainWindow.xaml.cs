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

namespace Tem_4_Actividad6
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

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            panel1.Visibility = Visibility.Visible;
            panel2.Visibility = Visibility.Hidden;
            panel3.Visibility = Visibility.Hidden;
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            panel1.Visibility = Visibility.Hidden;
            panel2.Visibility = Visibility.Visible;
            panel3.Visibility = Visibility.Hidden;
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            panel1.Visibility = Visibility.Hidden;
            panel2.Visibility = Visibility.Hidden;
            panel3.Visibility = Visibility.Visible;
        }

        private void Button_Click_3(object sender, RoutedEventArgs e)
        {
            System.Environment.Exit(1);
        }

        private void Button_Click_4(object sender, RoutedEventArgs e)
        {
            panel1.Visibility = Visibility.Visible;
            panel2.Visibility = Visibility.Hidden;
            panel3.Visibility = Visibility.Hidden;
        }
    }
}
