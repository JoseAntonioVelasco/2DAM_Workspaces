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

namespace Tema5Actividad3
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

        public Byte _clave;

        public Byte clave
        {
            get
            {
                return _clave;
            }
            set
            {
                if (value >= 1 && value < 20)
                {
                    _clave = value;
                }
                else
                {
                    MessageBox.Show("el valor debe estar entre 1 y 20");
                }

            }
        }

        private void mensaje_TextChanged(object sender, TextChangedEventArgs e)
        {
            string sentence = mensaje.Text;
            char[] charArr = sentence.ToCharArray();
            for(int i=0; i<charArr.Length; i++)
            {
                charArr[i] = (char)(charArr[i] + clave);
            }
            string string_object = new string(charArr);

            codificacion.Text = string_object;
        }
    }
}
