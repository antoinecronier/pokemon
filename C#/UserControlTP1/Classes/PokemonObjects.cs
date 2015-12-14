using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UserControlTP1.Classes
{
    class PokemonObjects
    {
        private int id_pokemon_objects;
        private String name;
        private int quantity;
        private Uri image;

        public PokemonObjects(int id_pokemon_objects, string name, int quantity, Uri image)
        {
            this.id_pokemon_objects = id_pokemon_objects;
            this.name = name;
            this.quantity = quantity;
            this.image = image;
        }

        public int Id_pokemon_objects
        {
            get
            {
                return id_pokemon_objects;
            }

            set
            {
                id_pokemon_objects = value;
            }
        }

        public string Name
        {
            get
            {
                return name;
            }

            set
            {
                name = value;
            }
        }

        public int Quantity
        {
            get
            {
                return quantity;
            }

            set
            {
                quantity = value;
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

    }
}
