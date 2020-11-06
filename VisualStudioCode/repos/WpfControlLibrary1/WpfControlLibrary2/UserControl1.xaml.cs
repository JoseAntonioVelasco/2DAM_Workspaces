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

namespace WpfControlLibrary2
{
    /// <summary>
    /// Lógica de interacción para UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl
    {
        public UserControl1()
        {
            InitializeComponent();
        }

        private void celsius_TextChanged(object sender, TextChangedEventArgs e)
        {
            try
            {
                kelvin.Text = Convert.ToString(Convert.ToDouble(celsius.Text) + 273);
            }
            catch { }
           
        }

        private void kelvin_TextChanged(object sender, TextChangedEventArgs e)
        {
            try
            {
                celsius.Text = Convert.ToString(Convert.ToDouble(kelvin.Text) - 273);
            }
            catch { }
           
        }
    }

}