using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UserControlTP1.Utilities;
using Windows.Foundation;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;

namespace UserControlTP1.Classes
{
    class GridManager
    {
        private Grid currentGrid;
        private List<ColumnDefinition> colDefs;
        private List<RowDefinition> rowDefs;
        private ColumnDefinitionCollection colDefCol;
        private RowDefinitionCollection rowDefCol;
        private Image player;
        private int coorX;
        private int coorY;

        public GridManager(ColumnDefinitionCollection colDefCol, RowDefinitionCollection rowDefCol, Grid currentGrid)
        {
            this.ColDefCol = colDefCol;
            this.RowDefCol = rowDefCol;
            this.CurrentGrid = currentGrid;
            this.CurrentGrid.SizeChanged += CurrentGrid_SizeChanged;

            this.ColDefs = new List<ColumnDefinition>();
            this.RowDefs = new List<RowDefinition>();

            foreach (var itemColDefs in this.ColDefCol)
            {
                ColDefs.Add(itemColDefs);
            }
            foreach (var itemRowDefs in this.RowDefCol)
            {
                RowDefs.Add(itemRowDefs);
            }

            this.Player = new Image();
            var bitmapImage = new BitmapImage();
            bitmapImage.UriSource = new Uri("http://www.pokepedia.fr/images/d/d9/Sprite_3_f_Red.png");
            this.Player.Name = "ImagePlayer";
            this.Player.Source = bitmapImage;
            this.CurrentGrid.Children.Add(this.Player);
        }

        public GridManager()
        {

        }

        private void CurrentGrid_SizeChanged(object sender, SizeChangedEventArgs e)
        {
            if (e.NewSize.Height > 0 && e.NewSize.Width > 0)
            {
                //UpdateItemsSize(e.NewSize);
            }
        }

        private void UpdateItemsSize(Size newSize)
        {
            this.ColDefCol.Clear();
            this.RowDefCol.Clear();
            ColumnDefinitionCollection colDefsColTemp1 = this.ColDefCol;
            RowDefinitionCollection rowDefColTemp1 = this.RowDefCol;

            List<ColumnDefinition> colDefsTemp1 = this.ColDefs;
            List<RowDefinition> rowDefsTemp1 = this.RowDefs;

            this.ColDefCol.Clear();
            this.RowDefCol.Clear();
            this.ColDefs.Clear();
            this.RowDefs.Clear();

            foreach (var itemColDefs in colDefsColTemp1)
            {
                itemColDefs.Width = new GridLength(newSize.Width / 13);
                ColDefs.Add(itemColDefs);
                ColDefCol.Add(itemColDefs);
            }
            foreach (var itemRowDefs in rowDefColTemp1)
            {
                itemRowDefs.Height = new GridLength(newSize.Height / 13);
                RowDefs.Add(itemRowDefs);
                RowDefCol.Add(itemRowDefs);
            }

            this.Player.Width = newSize.Width / 13;
            this.Player.Height = newSize.Height / 13;

            this.Move(this.CoorX, this.CoorY);
        }

        public void Move(int x, int y)
        {
            this.CoorX = x;
            this.CoorY = y;
            this.CurrentGrid.Children.Remove(this.Player);
            this.Player.SetValue(Grid.RowProperty, this.CoorY);
            this.Player.SetValue(Grid.ColumnProperty, this.CoorX);
            this.CurrentGrid.Children.Add(this.Player);
        }

        public void Move(int x, int y, WebView webView)
        {
            HTMLVariableSetter setter = new HTMLVariableSetter(webView);

            setter.ScriptInvocatorSetText("row-" + this.CoorY + "col-" + this.CoorX,
                "");

            this.CoorX = x;
            this.CoorY = y;
            
            setter.ScriptInvocatorSetText("row-" + this.CoorY + "col-" + this.CoorX,
                "<img src='http://www.pokepedia.fr/images/d/d9/Sprite_3_f_Red.png' alt='Alternate Text' />");
        }

        public List<ColumnDefinition> ColDefs
        {
            get
            {
                return colDefs;
            }

            set
            {
                colDefs = value;
            }
        }

        public List<RowDefinition> RowDefs
        {
            get
            {
                return rowDefs;
            }

            set
            {
                rowDefs = value;
            }
        }

        public ColumnDefinitionCollection ColDefCol
        {
            get
            {
                return colDefCol;
            }

            set
            {
                colDefCol = value;
            }
        }

        public RowDefinitionCollection RowDefCol
        {
            get
            {
                return rowDefCol;
            }

            set
            {
                rowDefCol = value;
            }
        }

        public Image Player
        {
            get
            {
                return player;
            }

            set
            {
                player = value;
            }
        }

        public int CoorX
        {
            get
            {
                return coorX;
            }

            set
            {
                if (value <= 12 && value >= 0)
                {
                    coorX = value;
                }
            }
        }

        public int CoorY
        {
            get
            {
                return coorY;
            }

            set
            {
                if (value <= 12 && value >= 0)
                {
                    coorY = value;
                }
            }
        }

        public Grid CurrentGrid
        {
            get
            {
                return currentGrid;
            }

            set
            {
                currentGrid = value;
            }
        }
    }
}
