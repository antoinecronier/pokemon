﻿#pragma checksum "C:\Users\tactfactory\Documents\Visual Studio 2015\Projects\CSharpTP\UserControlTP1\Pages\BlankPage2.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "7F06663A9E024A0E617CBD11FB887B6E"
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
    partial class BlankPage2 : 
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
                    #line 12 "..\..\..\Pages\BlankPage2.xaml"
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
                    this.btnNormalView = (global::Windows.UI.Xaml.Controls.Button)(target);
                    #line 28 "..\..\..\Pages\BlankPage2.xaml"
                    ((global::Windows.UI.Xaml.Controls.Button)this.btnNormalView).Click += this.btnWebview_Click;
                    #line default
                }
                break;
            case 7:
                {
                    this.webView = (global::Windows.UI.Xaml.Controls.WebView)(target);
                    #line 29 "..\..\..\Pages\BlankPage2.xaml"
                    ((global::Windows.UI.Xaml.Controls.WebView)this.webView).ScriptNotify += this.webView_ScriptNotify;
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

