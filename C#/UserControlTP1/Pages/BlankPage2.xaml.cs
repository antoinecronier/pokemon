using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using UserControlTP1.Classes;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Popups;
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
    public sealed partial class BlankPage2 : Page
    {
        GridManager gridManager;

        public BlankPage2()
        {
            this.InitializeComponent();

            this.webView.Source = new Uri("ms-appx-web:///Resources/HTMLPage1.html");

            ((Frame)Window.Current.Content).KeyUp += BlankPage2_KeyUp;

            gridManager = new GridManager();
            this.webView.NavigationCompleted += WebView_NavigationCompleted;
            this.webView.LoadCompleted += WebView_LoadCompleted;
        }

        private void WebView_LoadCompleted(object sender, NavigationEventArgs e)
        {
            this.webView.AllowedScriptNotifyUris = WebView.AnyScriptNotifyUri;
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            base.OnNavigatedFrom(e);
            ((Frame)Window.Current.Content).KeyUp -= BlankPage2_KeyUp;
            this.webView.NavigationCompleted -= WebView_NavigationCompleted; ;
        }

        private void WebView_NavigationCompleted(WebView sender, WebViewNavigationCompletedEventArgs args)
        {
            //this.webView.AllowedScriptNotifyUris.Add(new Uri("ms-appx-web:///Resources/HTMLPage1.html"));
            
            //gridManager.Move(7, 12, this.webView);
            gridManager.Move(0, 0, this.webView);
        }

        private void BlankPage2_KeyUp(object sender, KeyRoutedEventArgs e)
        {
            if (e.Key == Windows.System.VirtualKey.Down || e.Key == Windows.System.VirtualKey.S)
            {
                gridManager.Move(gridManager.CoorX, gridManager.CoorY + 1, this.webView);
            }
            if (e.Key == Windows.System.VirtualKey.Right || e.Key == Windows.System.VirtualKey.D)
            {
                gridManager.Move(gridManager.CoorX + 1, gridManager.CoorY, this.webView);
            }
            if (e.Key == Windows.System.VirtualKey.Left || e.Key == Windows.System.VirtualKey.Q)
            {
                gridManager.Move(gridManager.CoorX - 1, gridManager.CoorY, this.webView);
            }
            if (e.Key == Windows.System.VirtualKey.Up || e.Key == Windows.System.VirtualKey.Z)
            {
                gridManager.Move(gridManager.CoorX, gridManager.CoorY - 1, this.webView);
            }
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
                this.btnNormalView.SetValue(Grid.ColumnProperty, 0);
                this.btnNormalView.SetValue(Grid.RowProperty, 4);
                this.webView.MinHeight = 400;
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
                this.btnNormalView.SetValue(Grid.ColumnProperty, 0);
                this.btnNormalView.SetValue(Grid.RowProperty, 2);

                this.webView.MinHeight = 0;
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
            ((Frame)Window.Current.Content).Navigate(typeof(BlankPage1));
        }

        private async void webView_ScriptNotify(object sender, NotifyEventArgs e)
        {
            Windows.UI.Popups.MessageDialog dialog = new Windows.UI.Popups.MessageDialog(e.Value);
            dialog.Commands.Add(new UICommand("Yes"));
            dialog.Commands.Add(new UICommand("No"));

            // Set the command that will be invoked by default
            dialog.DefaultCommandIndex = 0;

            // Set the command to be invoked when escape is pressed
            dialog.CancelCommandIndex = 1;

            var result = await dialog.ShowAsync();

            if (result.Label.Equals("Yes"))
            {
                string res = await this.webView.InvokeScriptAsync("eval", new string[] { "window.confirm = function (ConfirmMessage) {return true}" });
            }
            else
            {
                string res = await this.webView.InvokeScriptAsync("eval", new string[] { "window.confirm = function (ConfirmMessage) {return false}" });
            }
        }
    }
}
