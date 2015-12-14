using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Windows.UI.Xaml.Controls;

namespace UserControlTP1.Utilities
{
    /// <summary>
    /// Manage HTML interaction
    /// </summary>
    class HTMLVariableSetter
    {
        #region Membres

        /// <summary>
        /// Current webview where you display your HTML
        /// </summary>
        WebView mWebView;

        #endregion

        #region Constructors

        /// <summary>
        /// HTMLVariableSetter constructor
        /// </summary>
        /// <param name="webview">The webview where you display your HTML</param>
        public HTMLVariableSetter(WebView webview)
        {
            mWebView = webview;
        }

        #endregion

        #region Methods

        /// <summary>
        /// Set top level attribut to value
        /// </summary>
        /// <param name="element">An HTML element's name</param>
        /// <param name="attribut">Attribut's name of the specified element</param>
        /// <param name="value">New value for the attribut</param>
        public void ScriptInvocatorSetAttribut(string element, string attribut, string value)
        {
            mWebView.InvokeScript("eval", new[]
            {
            "document.getElementById('"+element+"').setAttribute('"+attribut+"','"+value+"');"
        });
        }

        /// <summary>
        /// Set style attribut to value
        /// </summary>
        /// <param name="element">An HTML element's name</param>
        /// <param name="attribut">Name of the attribut to modify in the style attribut</param>
        /// <param name="value">New value for the attribut</param>
        public void ScriptInvocatorSetStyle(string element, string attribut, string value)
        {
            mWebView.InvokeScript("eval", new[]
            {
            "document.getElementById('"+element+"').style."+attribut+" = '"+value+"';"
        });
        }

        /// <summary>
        /// Add text in the selected element and escape '\n' by 'br' tag and ''' by '\\''
        /// </summary>
        /// <param name="element">An HTML element's name</param>
        /// <param name="value">Value to set on the object (old setted value will be erase)</param>
        public void ScriptInvocatorSetText(string element, string value)
        {
            String replacedValue = value.Replace("\n", "<br>");
            replacedValue = replacedValue.Replace("'", "\\'");
            try
            {
                mWebView.InvokeScript("Eval", new[]
                {
                  "document.getElementById('"+element+"').innerHTML = '"+value+"';"
                });
            }
            catch (Exception e)
            {
            }
            
        }

        #endregion

        #region Properties
        #endregion
    }
}
