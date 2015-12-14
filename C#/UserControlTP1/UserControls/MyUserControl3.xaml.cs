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
    public sealed partial class MyUserControl3 : UserControl
    {
        Flyout baseFlyout;

        public MyUserControl3()
        {
            this.InitializeComponent();

            ObservableCollection<PokemonObjects> pokemonObjects = new ObservableCollection<PokemonObjects>();
            pokemonObjects.Add(new PokemonObjects(1, "pokeball", 4, new Uri("http://www.pokepedia.fr/images/thumb/d/d6/Pok%C3%A9_ball_artwork.png/200px-Pok%C3%A9_ball_artwork.png")));
            pokemonObjects.Add(new PokemonObjects(2, "superball", 7, new Uri("http://www.pokepedia.fr/images/d/d6/Super_ball_artwork.png")));
            pokemonObjects.Add(new PokemonObjects(3, "potion", 2, new Uri("http://cdn.bulbagarden.net/upload/d/df/Dream_Potion_Sprite.png")));
            pokemonObjects.Add(new PokemonObjects(4, "guerison", 4, new Uri("http://cdn.bulbagarden.net/upload/d/df/Dream_Potion_Sprite.png")));
            pokemonObjects.Add(new PokemonObjects(5, "super bonbon", 10, new Uri("http://cdn.bulbagarden.net/upload/0/02/Dream_Rare_Candy_Sprite.png")));
            this.itemListView.ItemsSource = pokemonObjects;

            //Grid gridForFlyout = FindChildControl<Grid>(Window.Current.Content, "gridForFlyout") as Grid;
        }

        private void itemListView_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

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
                this.scrollViewer.VerticalAlignment = VerticalAlignment.Bottom;
                this.scrollViewer.HorizontalAlignment = HorizontalAlignment.Stretch;
            }
        }

        private DependencyObject FindChildControl<T>(DependencyObject control, string ctrlName)
        {
            int childNumber = VisualTreeHelper.GetChildrenCount(control);
            for (int i = 0; i < childNumber; i++)
            {
                DependencyObject child = VisualTreeHelper.GetChild(control, i);
                FrameworkElement fe = child as FrameworkElement;

                /* Not a framework element or is null */
                if (fe == null) return null;

                if (child is T && fe.Name == ctrlName)
                {
                    /* Found the control so return */
                    return child;
                }
                else
                {
                    /* Not found it - search children */
                    DependencyObject nextLevel = FindChildControl<T>(child, ctrlName);
                    if (nextLevel != null)
                        return nextLevel;
                }
            }
            return null;
        }

        private void gridForFlyout_RightTapped(object sender, RightTappedRoutedEventArgs e)
        {
            FrameworkElement senderElement = sender as FrameworkElement;

            baseFlyout = new Flyout();

            StackPanel stackPanel = new StackPanel();

            MenuFlyoutItem menuFlyoutItem = new MenuFlyoutItem();
            menuFlyoutItem.Margin = new Thickness(0);
            menuFlyoutItem.Text = "Select";
            stackPanel.Children.Add(menuFlyoutItem);
            menuFlyoutItem = new MenuFlyoutItem();
            menuFlyoutItem.Text = "Use on ...";
            menuFlyoutItem.Tapped += MenuFlyoutItem_Tapped;
            stackPanel.Children.Add(menuFlyoutItem);

            baseFlyout.Content = stackPanel;

            baseFlyout.ShowAt(senderElement);
            e.Handled = true;
        }

        private void MenuFlyoutItem_Tapped(object sender, TappedRoutedEventArgs e)
        {
            FrameworkElement senderElement = sender as FrameworkElement;

            baseFlyout = new Flyout();

            ScrollViewer scrollViewer = new ScrollViewer();
            scrollViewer.MaxHeight = 80;
            scrollViewer.IsVerticalScrollChainingEnabled = true;

            StackPanel stackPanel = new StackPanel();

            MenuFlyoutItem menuFlyoutItem;
            foreach (var pokemon in Pokemon.Instance.Pokemons)
            {
                menuFlyoutItem = new MenuFlyoutItem();
                //menuFlyoutItem.FontSize = 15;
                menuFlyoutItem.Text = pokemon.Surname;
                stackPanel.Children.Add(menuFlyoutItem);
            }
            scrollViewer.Content = stackPanel;

            baseFlyout.Content = scrollViewer;

            baseFlyout.ShowAt(senderElement);
            e.Handled = true;
        }
    }
}
