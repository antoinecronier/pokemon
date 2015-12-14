using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using UserControlTP1.Classes;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// The User Control item template is documented at http://go.microsoft.com/fwlink/?LinkId=234236

namespace UserControlTP1.UserControls
{
    public sealed partial class MyUserControl2 : UserControl
    {
        private int pokemonToSwitchOut = -1;
        private int pokemonToSwitchIn = -1;
        private ObservableCollection<Pokemon> pokemons;

        internal ObservableCollection<Pokemon> Pokemons
        {
            get
            {
                return pokemons;
            }

            set
            {
                pokemons = value;
            }
        }

        public MyUserControl2()
        {
            this.InitializeComponent();
            Pokemons = Pokemon.Instance.Pokemons;
            this.itemListView.ItemsSource = Pokemons;
        }

        private void ItemListView_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (pokemonToSwitchIn == -1)
            {
                if (pokemonToSwitchOut == -1)
                {
                    pokemonToSwitchOut = this.itemListView.SelectedIndex;
                }
                else
                {
                    pokemonToSwitchIn = this.itemListView.SelectedIndex;

                    Pokemon pokemonTempOut = Pokemons[pokemonToSwitchOut];
                    Pokemon pokemonTempIn = Pokemons[pokemonToSwitchIn];

                    Pokemons.Remove(pokemonTempOut);
                    Pokemons.Remove(pokemonTempIn);

                    if (pokemonToSwitchIn > pokemonToSwitchOut)
                    {
                        Pokemons.Insert(pokemonToSwitchOut, pokemonTempIn);
                        Pokemons.Insert(pokemonToSwitchIn, pokemonTempOut);
                    }
                    else
                    {
                        Pokemons.Insert(pokemonToSwitchIn, pokemonTempOut);
                        Pokemons.Insert(pokemonToSwitchOut, pokemonTempIn);
                    }

                    pokemonToSwitchIn = -1;
                    pokemonToSwitchOut = -1;
                }
            }
            
        }

        private void Grid_SizeChanged(object sender, SizeChangedEventArgs e)
        {
            if (e.NewSize.Width < 720)
            {
                this.scrollViewer.VerticalAlignment = VerticalAlignment.Center;
                this.scrollViewer.HorizontalAlignment = HorizontalAlignment.Center;
            }
            else if (e.NewSize.Width >= 720)
            {
                this.scrollViewer.VerticalAlignment = VerticalAlignment.Top;
                this.scrollViewer.HorizontalAlignment = HorizontalAlignment.Stretch;
            }
        }

        private void itemListView_RightTapped(object sender, RightTappedRoutedEventArgs e)
        {
            FrameworkElement senderElement = sender as FrameworkElement;
            FlyoutBase flyoutBase = FlyoutBase.GetAttachedFlyout(senderElement);

            flyoutBase.ShowAt(senderElement);
            e.Handled = true;
        }
    }
}
