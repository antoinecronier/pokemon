using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

// The User Control item template is documented at http://go.microsoft.com/fwlink/?LinkId=234236

namespace UserControlTP1.UserControls
{
    public sealed partial class MyUserControl1 : UserControl
    {
        DispatcherTimer timer = new DispatcherTimer();
        public MyUserControl1()
        {
            this.InitializeComponent();

            timer.Interval = TimeSpan.FromSeconds(1);
            timer.Tick += timer_Tick;
            timer.Start();

            var bitmapImage = new BitmapImage();
            bitmapImage.UriSource = new Uri("http://cdn-gulli.ladmedia.fr/var/jeunesse/storage/images/canalj/la-tele/dessins-animes/pokemon/personnages/les-dresseurs-de-pokemon/sacha/24007811-2-fre-FR/Sacha_image_player_432_324.jpg");

            this.ImageDresseur.Source = bitmapImage;
        }

        private void timer_Tick(object sender, object e)
        {
            this.TxtBTime.Text = DateTime.Now.Hour + "h:" + DateTime.Now.Minute + "m";
        }

        private void TxtBNomDresseur_Tapped(object sender, TappedRoutedEventArgs e)
        {

        }

        private void ImageDresseur_Tapped(object sender, TappedRoutedEventArgs e)
        {

        }

        private void TxtBTime_Tapped(object sender, TappedRoutedEventArgs e)
        {

        }

        private void Grid_SizeChanged(object sender, SizeChangedEventArgs e)
        {
            if (e.NewSize.Width < 720)
            {
                this.TxtBNomDresseur.FontSize = 20;
                this.TxtBNomZone.FontSize = 20;
                this.TxtBTime.FontSize = 20;
                this.colDefMid.Width = new GridLength(2,GridUnitType.Star);
            }
            else if (e.NewSize.Width >= 720)
            {
                this.TxtBNomDresseur.FontSize = 30;
                this.TxtBNomZone.FontSize = 30;
                this.TxtBTime.FontSize = 30;
                this.colDefMid.Width = new GridLength(3, GridUnitType.Star);
            }
        }

        private void btnBack_Tapped(object sender, TappedRoutedEventArgs e)
        {
            ((Frame)Window.Current.Content).Navigate(typeof(MainPage));
        }

        public Image DresseurImage
        {
            get
            {
                return this.ImageDresseur;
            }

            set
            {
                this.ImageDresseur = value;
            }
        }
    }
}
