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

namespace CrearComponente
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

        public String _mayusculas;
        public Byte _edad;

        public Byte edad
        {
            get
            {
                return _edad;
            }
            set
            {
                if (value >= 0 && value < 99)
                {
                    _edad = value;
                }
                else
                {
                    MessageBox.Show("el valor debe estar entre 0 y 99");
                }
            }
        }
        public void reiniciar()
        {
            //mayusculas = "";
            //tbox.Text = _mayusculas;
            edad = byte.Parse(tbox.Text);
        }

        //evento
        private void cambioColor(Object e, System.Windows.Controls.TextChangedEventArgs target)
        {
            tbox.Foreground = new SolidColorBrush(Color.FromRgb(240, 0, 0));
        }
    }

}

