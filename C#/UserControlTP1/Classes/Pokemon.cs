using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UserControlTP1.Classes
{
    class Pokemon
    {
        private ObservableCollection<Pokemon> pokemons;

        #region Singleton
        private static volatile Pokemon instance;
        private static object syncRoot = new Object();

        private Pokemon()
        {
            Pokemons = new ObservableCollection<Pokemon>();
            Pokemons.Add(new Pokemon(0, "pikachu", "electrik", new Uri("http://cdn.bulbagarden.net/upload/thumb/0/0d/025Pikachu.png/250px-025Pikachu.png")));
            Pokemons.Add(new Pokemon(1, "evoli", "normal", new Uri("http://www.pokepedia.fr/images/thumb/8/8b/%C3%89voli-RFVF.png/250px-%C3%89voli-RFVF.png")));
            Pokemons.Add(new Pokemon(2, "machopeur", "combat", new Uri("http://www.pokepedia.fr/images/thumb/c/cf/Machopeur-RFVF.png/250px-Machopeur-RFVF.png")));
            Pokemons.Add(new Pokemon(3, "taupiqueur", "sol", new Uri("http://www.pokepedia.fr/images/thumb/a/aa/Taupiqueur-RFVF.png/250px-Taupiqueur-RFVF.png")));
            Pokemons.Add(new Pokemon(4, "roucoul", "vol", new Uri("http://www.pokepedia.fr/images/thumb/9/94/Roucool-RFVF.png/250px-Roucool-RFVF.png")));
        }

        public static Pokemon Instance
        {
            get
            {
                if (instance == null)
                {
                    lock (syncRoot)
                    {
                        if (instance == null)
                            instance = new Pokemon();
                    }
                }

                return instance;
            }
        }
        #endregion

        private int id_pokemon;
        private String surname;
        private String type;
        private Uri image;

        public int Id_pokemon
        {
            get
            {
                return id_pokemon;
            }

            set
            {
                id_pokemon = value;
            }
        }

        public string Surname
        {
            get
            {
                return surname;
            }

            set
            {
                surname = value;
            }
        }

        public string Type
        {
            get
            {
                return type;
            }

            set
            {
                type = value;
            }
        }

        public Uri Image
        {
            get
            {
                return image;
            }

            set
            {
                image = value;
            }
        }

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

        public Pokemon(int id_pokemon, string surname, string type, Uri image)
        {
            this.Id_pokemon = id_pokemon;
            this.Surname = surname;
            this.Type = type;
            this.Image = image;
        }
    }
}
