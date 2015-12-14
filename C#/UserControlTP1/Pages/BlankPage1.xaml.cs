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
using Windows.UI.Xaml.Navigation;

// Pour plus d'informations sur le modèle d'élément Page vierge, voir la page http://go.microsoft.com/fwlink/?LinkId=234238

namespace UserControlTP1.Pages
{
    /// <summary>
    /// Une page vide peut être utilisée seule ou constituer une page de destination au sein d'un frame.
    /// </summary>
    public sealed partial class BlankPage1 : Page
    {
        public BlankPage1()
        {
            this.InitializeComponent();
        }

        private void Grid_SizeChanged(object sender, SizeChangedEventArgs e)
        {
            ColumnDefinitionCollection colDefCol;
            ColumnDefinition colDef;
            RowDefinitionCollection rowDefCol;
            RowDefinition rowDef;

            if (e.NewSize.Width < 720)
            {
                colDefCol = baseGrid.ColumnDefinitions;
                colDefCol.Clear();
                colDef = new ColumnDefinition();
                colDefCol.Add(colDef);

                rowDefCol = baseGrid.RowDefinitions;
                rowDefCol.Clear();
                rowDef = new RowDefinition();
                rowDefCol.Add(rowDef);
                rowDef = new RowDefinition();
                rowDefCol.Add(rowDef);
                rowDef = new RowDefinition();
                rowDefCol.Add(rowDef);
                rowDef = new RowDefinition();
                rowDefCol.Add(rowDef);
                rowDef = new RowDefinition();
                rowDefCol.Add(rowDef);

                this.MyUserControl2.SetValue(Grid.ColumnProperty, 0);
                this.MyUserControl2.SetValue(Grid.RowProperty, 2);
                this.MyUserControl2.HorizontalAlignment = HorizontalAlignment.Stretch;
                this.MyUserControl3.SetValue(Grid.ColumnProperty, 0);
                this.MyUserControl3.SetValue(Grid.RowProperty, 3);
                this.MyUserControl3.HorizontalAlignment = HorizontalAlignment.Stretch;
                this.scrollViewer.HorizontalScrollBarVisibility = ScrollBarVisibility.Auto;
                this.scrollViewer.VerticalScrollBarVisibility = ScrollBarVisibility.Auto;
                this.btnWebview.SetValue(Grid.ColumnProperty, 0);
                this.btnWebview.SetValue(Grid.RowProperty, 4);
                this.MyUserControl4.MinHeight = 400;
            }
            else if (e.NewSize.Width >= 720)
            {
                colDefCol = baseGrid.ColumnDefinitions;
                colDefCol.Clear();
                colDef = new ColumnDefinition();
                colDefCol.Add(colDef);
                colDef = new ColumnDefinition();
                colDefCol.Add(colDef);
                colDef = new ColumnDefinition();
                colDefCol.Add(colDef);

                rowDefCol = baseGrid.RowDefinitions;
                rowDefCol.Clear();
                rowDef = new RowDefinition();
                rowDef.Height = new GridLength(1, GridUnitType.Star);
                rowDefCol.Add(rowDef);
                rowDef = new RowDefinition();
                rowDef.Height = new GridLength(8, GridUnitType.Star);
                rowDefCol.Add(rowDef);
                rowDef = new RowDefinition();
                rowDef.Height = new GridLength(1, GridUnitType.Star);
                rowDefCol.Add(rowDef);

                this.MyUserControl2.SetValue(Grid.ColumnProperty, 2);
                this.MyUserControl2.SetValue(Grid.RowProperty, 1);
                this.MyUserControl2.HorizontalAlignment = HorizontalAlignment.Right;
                this.scrollViewer.HorizontalScrollBarVisibility = ScrollBarVisibility.Disabled;
                this.scrollViewer.VerticalScrollBarVisibility = ScrollBarVisibility.Disabled;
                this.MyUserControl3.SetValue(Grid.ColumnProperty, 2);
                this.MyUserControl3.SetValue(Grid.RowProperty, 1);
                this.MyUserControl3.HorizontalAlignment = HorizontalAlignment.Right;
                this.btnWebview.SetValue(Grid.ColumnProperty, 0);
                this.btnWebview.SetValue(Grid.RowProperty, 2);

                this.MyUserControl4.MinHeight = 0;
            }

            if (e.NewSize.Height < 600 && e.NewSize.Width >= 720)
            {
                this.MyUserControl3.SetValue(Grid.ColumnProperty, 0);
                this.MyUserControl3.SetValue(Grid.RowProperty, 1);
                this.MyUserControl3.HorizontalAlignment = HorizontalAlignment.Left;
                this.MyUserControl3.VerticalAlignment = VerticalAlignment.Top;
                this.MyUserControl1.DresseurImage.Visibility = Visibility.Collapsed;
            }
            else if (e.NewSize.Height >= 600 && e.NewSize.Width >= 720)
            {
                rowDefCol = baseGrid.RowDefinitions;
                rowDefCol.Clear();
                rowDef = new RowDefinition();
                rowDef.Height = new GridLength(1, GridUnitType.Auto);
                rowDefCol.Add(rowDef);
                rowDef = new RowDefinition();
                rowDef.Height = new GridLength(8, GridUnitType.Star);
                rowDefCol.Add(rowDef);
                rowDef = new RowDefinition();
                rowDef.Height = new GridLength(1, GridUnitType.Star);
                rowDefCol.Add(rowDef);

                this.MyUserControl3.SetValue(Grid.ColumnProperty, 2);
                this.MyUserControl3.SetValue(Grid.RowProperty, 1);
                this.MyUserControl3.HorizontalAlignment = HorizontalAlignment.Right;
                this.MyUserControl3.VerticalAlignment = VerticalAlignment.Bottom;
                this.MyUserControl1.DresseurImage.Visibility = Visibility.Visible;
            }
        }

        private void btnWebview_Click(object sender, RoutedEventArgs e)
        {
            ((Frame)Window.Current.Content).Navigate(typeof(BlankPage2));
        }
    }
}
