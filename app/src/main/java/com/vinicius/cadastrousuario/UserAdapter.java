package com.vinicius.cadastrousuario;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//CLasse Adapter: Gerencia a criação e o preenchimento dos itens na RecycleView
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    //Atributo privado que armazena a referencia dos dados que serão exibidos
    private List<String> listaUsuarios;

    //Construtor que permite  a MainActivity "entregue" a lista de dados para este Adapter
    public UserAdapter(list<String> lista){
        this.listaUsuarios = lista;

    }

    //Método1: Cria "do zero" o visual de uma linha de lista (+ViewHolder)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //LayoutInflater transforma o arquivo XML em um objeto View Java
        //Aqui usamos um layout padrão do Android (simple_list_item_1) para facilitar
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);

    }
    //Método 2: Vincula os dados de um objeto de uma linha específica da tela

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        // Recupera os dados da lista de acordo com a posição que o Android está desenhando agora
        String nome = listaUsuarios.get(position);

        //Define o texto no componente visual que está guardado dentro de 'holder'
        holder.tvNome.setText(nome);
    }


    //Método 3: Informa ao Android quantos itens a lista possui ao todo
    @Override
    public int getItemCount(){
        //Se a lista existir, retorna o tamanho. Se não, retorna zero
        return listaUsuarios != null ? listaUsuarios.size() : 0;
    }

    //Classe interna ViewHolder: Servir para "segurar" as referências dos componentes de cada linha
    //Evitar chamadas respectivas ao findViewById, melhorando a performance do RecycleView

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Referência para o TextView da linha
        TextView tvNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Faz o mapeamento do ID do layout para o objeto java
            //android.R.id.text1 é o ID padrão do layout 'simple_list_item_1'
            tvNome = itemView.findViewById((android.R.id.text1));
        }
    }
}
