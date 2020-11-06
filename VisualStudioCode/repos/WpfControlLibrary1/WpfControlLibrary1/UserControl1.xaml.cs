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

namespace WpfControlLibrary1
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

        /*private void Celsius_KeyUp(object sender, KeyEventArgs e)
        {

            if (celsius.Text.Equals(""))
            {
                
            }
            else
            {
                kelvin.Text = Convert.ToString(Convert.ToDouble(celsius.Text) + 273);
            }
            
           
        }*/

        /*private void Kelvin_KeyUp(object sender, KeyEventArgs e)
        {
            if (kelvin.Text.Equals(""))
            {
               
            }
            else
            {
               celsius.Text = Convert.ToString(Convert.ToDouble(kelvin.Text) - 273);
            }
           
        }*/

        private void celsius_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (kelvin.Text.Equals(""))
            {
                //|| celsius.Text.Equals("")
            }
            else
            {
                kelvin.Text = Convert.ToString(Convert.ToDouble(celsius.Text) + 273);
            }
            
        }

        private void kelvin_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (kelvin.Text.Equals(""))
            {
                //|| celsius.Text.Equals("")
            }
            else
            {
                celsius.Text = Convert.ToString(Convert.ToDouble(kelvin.Text) - 273);
            }
            
        }

    }
}
