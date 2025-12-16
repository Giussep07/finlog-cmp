@file:OptIn(ExperimentalMaterial3Api::class)

package dev.giussepr.finlog.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.giussepr.finlog.core.theme.FinlogTheme
import dev.giussepr.finlog.core.theme.extendedColors
import dev.giussepr.finlog.home.presentation.model.BalanceOverviewUiModel
import finlog.composeapp.generated.resources.Res
import finlog.composeapp.generated.resources.balance
import finlog.composeapp.generated.resources.balance_overview
import finlog.composeapp.generated.resources.expenses
import finlog.composeapp.generated.resources.income
import finlog.composeapp.generated.resources.last_6_months
import finlog.composeapp.generated.resources.last_transactions
import finlog.composeapp.generated.resources.view_all
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
            BalanceCard()
            // Income Card
            BalanceIconCard(
                modifier = Modifier
                    .padding(top = 16.dp),
                title = stringResource(Res.string.income),
                icon = Icons.Default.ArrowUpward,
                color = MaterialTheme.extendedColors.income
            )
            // Expense Card
            BalanceIconCard(
                modifier = Modifier
                    .padding(top = 16.dp),
                title = stringResource(Res.string.expenses),
                icon = Icons.Default.ArrowDownward,
                color = MaterialTheme.extendedColors.expense
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 12.dp),
                text = stringResource(Res.string.balance_overview),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            val months = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun")
            val percentages = listOf(0.95f, 0.6f, 0.1f, 0.6f, 0.8f, 1f)
            val data = List(6) { index ->
                BalanceOverviewUiModel(
                    period = months[index],
                    percentageChange = percentages[index]
                )
            }
            BalanceOverviewCard(data = data)

            LastTransactionsCard()
        }
}

@Composable
private fun BalanceCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        ),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.balance),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "$12,345.67",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun BalanceIconCard(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    color: Color
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        ),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    imageVector = icon,
                    contentDescription = null,
                    tint = color
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = "$12,345.67",
                style = MaterialTheme.typography.headlineSmall,
                color = color,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
private fun BalanceOverviewCard(
    modifier: Modifier = Modifier,
    data: List<BalanceOverviewUiModel> = emptyList()
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        ),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(Res.string.last_6_months),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "+5.4%",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.extendedColors.income
                    )
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                        contentDescription = null,
                        tint = MaterialTheme.extendedColors.income
                    )
                }
            }
            BalanceOverviewChart(
                modifier = Modifier
                    .fillMaxWidth(),
                data = data
            )
        }
    }
}

@Composable
private fun BalanceOverviewChart(
    modifier: Modifier = Modifier,
    data: List<BalanceOverviewUiModel>
) {
    Row(
        modifier = modifier
            .padding(top = 8.dp)
            .height(160.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        data.forEachIndexed { index, item ->
            val isLastItem = data.lastIndex == index
            val barHeight = (((item.percentageChange * 100) * 140) / 100).coerceAtLeast(0f)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = if (isLastItem) 1f else 0.2f),
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                        .height(barHeight.dp)
                        .fillMaxWidth()
                )
                Text(
                    modifier = Modifier,
                    text = item.period,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = if (isLastItem) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}

@Composable
private fun LastTransactionsCard(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = stringResource(Res.string.last_transactions),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier,
            text = stringResource(Res.string.view_all),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TransactionListItem(
            icon = Icons.Default.ShoppingCart,
            title = "Grocery Shopping",
            description = "Walmart",
            amount = "-$150.00",
            isIncome = false
        )

        TransactionListItem(
            icon = Icons.Default.Payments,
            title = "Salary",
            description = "Company Inc.",
            amount = "+$3,500.00",
            isIncome = true
        )

        TransactionListItem(
            icon = Icons.Default.Coffee,
            title = "Coffee",
            description = null,
            amount = "-$4.50",
            isIncome = false
        )
    }
}

@Composable
private fun TransactionListItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    description: String?,
    amount: String,
    isIncome: Boolean
) {
    val color = if (isIncome) {
        MaterialTheme.extendedColors.income
    } else {
        MaterialTheme.extendedColors.expense
    }
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        ),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color.copy(alpha = 0.1f), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    imageVector = icon,
                    contentDescription = null,
                    tint = color
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.SemiBold
                )
                description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Text(
                text = amount,
                style = MaterialTheme.typography.bodyLarge,
                color = color,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    FinlogTheme {
        HomeContent()
    }
}