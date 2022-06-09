# EZBudget

Actions handled by a `Controller` as a template for all controllers:

<table>
<thead>
<tr>
<th>HTTP Method</th>
<th>URL</th>
<th>Controller Method</th>
</tr>
</thead>
<tbody>
<tr>
<td>GET</td>
<td><code>/customers</code></td>
<td>index</td>
</tr>
<tr>
<td>GET</td>
<td><code>/customers/create</code></td>
<td>create</td>
</tr>
<tr>
<td>POST</td>
<td><code>/customers</code></td>
<td>store</td>
</tr>
<tr>
<td>GET</td>
<td><code>/customers/{customer_id}</code></td>
<td>show</td>
</tr>
<tr>
<td>GET</td>
<td><code>/customers/{customer_id}/edit</code></td>
<td>edit</td>
</tr>
<tr>
<td>PUT/PATCH</td>
<td><code>/customers/{customer_id}</code></td>
<td>update</td>
</tr>
<tr>
<td>DELETE</td>
<td><code>/customers/{customer_id}</code></td>
<td>destroy</td>
</tr>
</tbody>
</table>
