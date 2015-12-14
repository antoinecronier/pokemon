using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading;
using System.Threading.Tasks;
using UserControlTP1.Classes;
using Windows.ApplicationModel.Core;
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
    public sealed partial class MyUserControl4 : UserControl
    {
        GridManager gridManager;
        public MyUserControl4()
        {
            this.InitializeComponent();
            //Task.Factory.StartNew(() =>
            //{
            //    AutoResetEvent shedule = new AutoResetEvent(false);
            //    shedule.WaitOne(TimeSpan.FromSeconds(2));
            //    CoreApplication.MainView.CoreWindow.Dispatcher.RunAsync(
            //Windows.UI.Core.CoreDispatcherPriority.Normal,
            //        () =>
            //        {
            //            gridManager = new GridManager(this.playGrid.ColumnDefinitions, this.playGrid.RowDefinitions, this.playGrid);
            //            gridManager.Move(7, 13);
            //        });

            //});
            gridManager = new GridManager(this.playGrid.ColumnDefinitions, this.playGrid.RowDefinitions, this.playGrid);
            gridManager.Move(6, 12);

            ((Frame)Window.Current.Content).KeyUp += MyUserControl4_KeyUp;
        }

        private void MyUserControl4_KeyUp(object sender, KeyRoutedEventArgs e)
        {
            if (e.Key == Windows.System.VirtualKey.Down || e.Key == Windows.System.VirtualKey.S)
            {
                gridManager.Move(gridManager.CoorX, gridManager.CoorY +1);
            }
            if (e.Key == Windows.System.VirtualKey.Right || e.Key == Windows.System.VirtualKey.D)
            {
                gridManager.Move(gridManager.CoorX +1, gridManager.CoorY);
            }
            if (e.Key == Windows.System.VirtualKey.Left || e.Key == Windows.System.VirtualKey.Q)
            {
                gridManager.Move(gridManager.CoorX -1, gridManager.CoorY);
            }
            if (e.Key == Windows.System.VirtualKey.Up || e.Key == Windows.System.VirtualKey.Z)
            {
                gridManager.Move(gridManager.CoorX, gridManager.CoorY -1);
            }
        }
    }
}
