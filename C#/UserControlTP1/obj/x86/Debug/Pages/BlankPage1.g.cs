﻿#pragma checksum "C:\Users\tactfactory\Documents\Visual Studio 2015\Projects\CSharpTP\UserControlTP1\Pages\BlankPage1.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "C95C1C0F89590127C1787F812520A258"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace UserControlTP1.Pages
{
    partial class BlankPage1 : 
        global::Windows.UI.Xaml.Controls.Page, 
        global::Windows.UI.Xaml.Markup.IComponentConnector,
        global::Windows.UI.Xaml.Markup.IComponentConnector2
    {
        /// <summary>
        /// Connect()
        /// </summary>
        [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Windows.UI.Xaml.Build.Tasks"," 14.0.0.0")]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void Connect(int connectionId, object target)
        {
            switch(connectionId)
            {
            case 1:
                {
                    this.scrollViewer = (global::Windows.UI.Xaml.Controls.ScrollViewer)(target);
                }
                break;
            case 2:
                {
                    this.baseGrid = (global::Windows.UI.Xaml.Controls.Grid)(target);
                    #line 12 "..\..\..\Pages\BlankPage1.xaml"
                    ((global::Windows.UI.Xaml.Controls.Grid)this.baseGrid).SizeChanged += this.Grid_SizeChanged;
                    #line default
                }
                break;
            case 3:
                {
                    this.MyUserControl1 = (global::UserControlTP1.UserControls.MyUserControl1)(target);
                }
                break;
            case 4:
                {
                    this.MyUserControl2 = (global::UserControlTP1.UserControls.MyUserControl2)(target);
                }
                break;
            case 5:
                {
                    this.MyUserControl3 = (global::UserControlTP1.UserControls.MyUserControl3)(target);
                }
                break;
            case 6:
                {
                    this.MyUserControl4 = (global::UserControlTP1.UserControls.MyUserControl4)(target);
                }
                break;
            case 7:
                {
                    this.btnWebview = (global::Windows.UI.Xaml.Controls.Button)(target);
                    #line 29 "..\..\..\Pages\BlankPage1.xaml"
                    ((global::Windows.UI.Xaml.Controls.Button)this.btnWebview).Click += this.btnWebview_Click;
                    #line default
                }
                break;
            default:
                break;
            }
            this._contentLoaded = true;
        }

        [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Windows.UI.Xaml.Build.Tasks"," 14.0.0.0")]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public global::Windows.UI.Xaml.Markup.IComponentConnector GetBindingConnector(int connectionId, object target)
        {
            global::Windows.UI.Xaml.Markup.IComponentConnector returnValue = null;
            return returnValue;
        }
    }
}

